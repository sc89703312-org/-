package client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.dataservice.userdataservice.UserDataService;
import client.dataservice.userdataservice.UserMessageDataService;
import client.po.Role;
import client.po.StaffChange;
import client.po.userpo.UserMessagePO;
import client.po.userpo.UserPO;
import client.vo.UserMessageVO;
import client.vo.uservo.EmployeeVO;

public class UserBl implements UserBlService {

	UserDataService userData;
	UserMessageDataService userMessageData;

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

	UserMessageVO convertToVO(UserMessagePO po) {

		return new UserMessageVO(po.getOperation(), po.getId(), po.getName(), po.getRole());
	}

	@Override
	public ArrayList<UserMessageVO> viewTask() {
		ArrayList<UserMessagePO> listPo = null;
		
		try {
			listPo = userMessageData.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<UserMessageVO> listVo = new ArrayList<UserMessageVO>();

		for (int i = 0; i < listPo.size(); i++) {
			listVo.add(convertToVO(listPo.get(i)));
		}
		return listVo;
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

}
