package client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.dataservice.userdataservice.UserDataService;
import client.po.Role;
import client.po.userpo.UserPO;
import client.vo.uservo.EmployeeVO;

public class UserBl implements UserBlService{

	UserDataService userData;
	
	public UserBl(){
		userData = new MockUserData();
	}
	
	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		ResultMessage rm = null;
		try {
			if(userData.find(id)!=null)
				rm = ResultMessage.INVALID;
			else{
				userData.insert(id, name, role, password);
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
			if(userData.find(id)==null)
				rm = ResultMessage.INVALID;
			else{
				userData.delete(id);
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
			if(userData.find(id)==null)
				rm = ResultMessage.INVALID;
			else{
				userData.modify(id, name, role, password);
				rm =  ResultMessage.VALID;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rm;
	}
	
	public ArrayList<EmployeeVO> viewEmployeeList(){
		ArrayList<UserPO> listPo = null;
		ArrayList<EmployeeVO> listVo = new ArrayList<EmployeeVO>();
		try {
			listPo = userData.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < listPo.size(); i ++){
			listVo.add(convertToVO(listPo.get(i)));
		}
		return listVo;
	}
	
	EmployeeVO convertToVO(UserPO po){
		
		return new EmployeeVO(po.getId(), po.getName(), po.getRole());	
	}

	
}
