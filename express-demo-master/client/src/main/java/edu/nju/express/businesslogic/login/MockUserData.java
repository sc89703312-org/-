package edu.nju.express.businesslogic.login;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.po.UserPO;

public class MockUserData implements UserDataService{

	
	ArrayList<UserPO> users;
	
	public MockUserData() {
		// TODO Auto-generated constructor stub
	
		users = new ArrayList<>();
		users.add(new UserPO("admin", "Sc", Role.ADMINISTRATOR, "admin"));
	}
	
	
	
	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage modify(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.VALID;
	}

	@Override
	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
