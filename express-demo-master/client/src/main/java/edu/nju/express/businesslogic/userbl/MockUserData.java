package edu.nju.express.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.po.UserPO;



public class MockUserData implements UserDataService{

	ArrayList<UserPO> list = new ArrayList<UserPO>();
	
	@Override
	public void insert(String id, String name, Role role, String password) throws RemoteException {
		list.add(new UserPO(id, name, role, password));
	}

	@Override
	public void delete(String id) throws RemoteException {
		list.remove(find(id));
	}

	@Override
	public void modify(String id, String name, Role role, String password) throws RemoteException {
		list.remove(find(id));
		list.add(new UserPO(id, name, role, password));
	}

	@Override
	public UserPO find(String id) throws RemoteException {
		if(id.equals("025000001")){
			return new UserPO("025000001", "A", Role.ACCOUNTANT, "123456");
		}
		return null;
	}

	@Override
	public ArrayList<UserPO> getAll() throws RemoteException {
		if(list.isEmpty())
			System.out.println("Empty");
		return list;
	}

}
