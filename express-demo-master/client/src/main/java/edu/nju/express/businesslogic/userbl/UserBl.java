package edu.nju.express.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.po.UserPO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.UserMessageVO;



public class UserBl implements UserBlService {

	UserDataService userData;
	UserMessageDataService userMessageData;
	TaskList task;

	public UserBl() {
		userData = new MockUserData();
		userMessageData = new MockUserMessageData();
	}

	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		ResultMessage rm = null;
		try {
			if (userData.find(id) != null)
				rm = ResultMessage.INVALID;
			else {
				userData.insert(id, name, role, password);
				rm = ResultMessage.VALID;
				deleteUserMessage(id);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rm;
	}

	@Override
	public ResultMessage deleteUser(String id) {
		ResultMessage rm = null;
		try {
			if (userData.find(id) == null)
				rm = ResultMessage.INVALID;
			else {
				userData.delete(id);
				rm = ResultMessage.VALID;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rm;
	}

	@Override
	public ResultMessage modifyUser(String id, String name, Role role, String password) {
		ResultMessage rm = null;
		try {
			if (userData.find(id) == null)
				rm = ResultMessage.INVALID;
			else {
				userData.modify(id, name, role, password);
				rm = ResultMessage.VALID;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rm;
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
					userMessageData.insert(operation, id, name, role);
					rm = ResultMessage.VALID;
				}

			} catch (RemoteException e) {
				e.printStackTrace();
			}

		} else if (operation == StaffChange.delete) {

				try {
					if (userData.find(id) != null) {
						userMessageData.insert(operation, id, name, role);
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
