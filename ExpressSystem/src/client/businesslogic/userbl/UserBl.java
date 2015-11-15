package client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.dataservice.userdataservice.UserDataService;
import client.po.Role;
import client.vo.uservo.UserVO;

public class UserBl implements UserBlService{

	UserDataService userDataService;
	
	public UserBl(){
		
	}
	
	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		ResultMessage rm = null;
		try {
			if(userDataService.find(id)!=null)
				rm = ResultMessage.INVALID;
			else{
				userDataService.insert(id, name, role, password);
				rm =  ResultMessage.VALID;
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
			if(userDataService.find(id)==null)
				rm = ResultMessage.INVALID;
			else{
				userDataService.delete(id);
				rm =  ResultMessage.VALID;
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
			if(userDataService.find(id)==null)
				rm = ResultMessage.INVALID;
			else{
				userDataService.modify(id, name, role, password);
				rm =  ResultMessage.VALID;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rm;
	}
	
	public ArrayList<UserVO> viewEmployeeList(){
		ArrayList<UserVO> list = null;
		try {
			list = userDataService.showAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

}
