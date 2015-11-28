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
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.po.UserPO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.UserMessageVO;

public class UserBl implements UserBlService ,UserCreateMessageInfo{

	UserDataService userData;
	UserMessageDataService userMessageData;
	TaskList task;

	public UserBl() {
	}

	
	
	
	
	
	
	
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

	EmployeeVO convertToVO(UserPO po) {

		return new EmployeeVO(po.getId(), po.getName(), po.getRole());
	}

	@Override
	public ArrayList<UserMessageVO> viewTask() {
		task = new TaskList();
		return task.viewTask();
	}

	public ResultMessage createUserMessage(StaffChange operation, String id, String name, Role role) {

		ResultMessage rm = ResultMessage.INVALID;
		if (operation == StaffChange.add) {

			try {

				if (userData.find(id) == null) {
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

	public ResultMessage deleteUserMessage(String id) {

		return null;

	}

}
