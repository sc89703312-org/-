package edu.nju.express.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.businesslogic.strategybl.managementbl.Info.UserCreateMessageInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.po.UserPO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.UserMessageVO;
/**
 * 账号管理的功能实现
 * @author Dora
 * @version 2015-12-9 23:14:26
 */
public class UserBl implements UserBlService ,UserCreateMessageInfo{


	UserDataService userData;
	UserMessageDataService userMessageData;
	TaskList task;
	public UserBl() {
		userData = RMIHelper.getUserDataService();
		userMessageData = RMIHelper.getUserMessageDataService();
	}

	
	
	/**
	 * 添加人员的功能实现
	 */
	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		try {
			userData.insert(new UserPO(id, name, role, password));
			deleteUserMessage(id);
			return ResultMessage.VALID;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.INVALID;
	}

	/**
	 * 删除人员的功能实现
	 */
	@Override
	public ResultMessage deleteUser(String id) {
		try {

			userData.delete(id);
			return ResultMessage.VALID;

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.INVALID;
	}

	/**
	 * 修改人员的功能实现
	 */
	@Override
	public ResultMessage modifyUser(String id, String name, Role role, String password) {
		try {
			
				userData.modify(new UserPO(id, name, role, password));
				return ResultMessage.VALID;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.INVALID;
	}

	
	/**
	 * 查看人员列表的功能实现
	 */
	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		ArrayList<UserPO> listPo = null;
		ArrayList<EmployeeVO> listVo = new ArrayList<EmployeeVO>();
		try {
			listPo = userData.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < listPo.size(); i++) {
			listVo.add(convertToVO(listPo.get(i)));
		}
		return listVo;
	}

	
	
	/*
	 * 将账号的持久化对象转化为vo
	 */
	EmployeeVO convertToVO(UserPO po) {

		return new EmployeeVO(po.getId(), po.getName(), po.getRole());
	}

	
	
	/**
	 * 查看人员管理任务的功能实现
	 */
	@Override
	public ArrayList<UserMessageVO> viewTask() {
		task = new TaskList();
		return task.viewTask();
	}
	
	
	
	/**
	 * 生成一个人员变动管理任务的功能实现
	 */
	@Override
	public ResultMessage createUserMessage(StaffChange operation, String id, String name, Role role) {

		ResultMessage rm = ResultMessage.INVALID;
		if (operation == StaffChange.add) {

			try {

				if (userMessageData.find(id) ==null) {
					userMessageData.insert(new UserMessagePO(operation, id, name, role));
					rm = ResultMessage.VALID;
				}

			} catch (RemoteException e) {
				e.printStackTrace();
			}

		} else if (operation == StaffChange.delete) {

			try {
				if (userData.find(id) != null) {
					userMessageData.insert(new UserMessagePO(operation, id, name, role));
					rm = ResultMessage.VALID;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		}

		return rm;
	}

	/**
	 * 删除一个人员管理任务
	 * @author Dora
	 * @param id
	 * @return
	 */
	public ResultMessage deleteUserMessage(String id) {

		try {
			return userMessageData.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
