package client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.dataservice.userdataservice.UserMessageDataService;
import client.po.Role;
import client.po.StaffChange;
import client.po.userpo.UserMessagePO;

public class MockUserMessageData implements UserMessageDataService{

	ArrayList<UserMessagePO> list ;

	
	public MockUserMessageData() {
		this.list = new ArrayList<UserMessagePO>();
		
		list.add(new UserMessagePO(StaffChange.add, "0250000003", "B", Role.POSTMAN));
		list.add(new UserMessagePO(StaffChange.add, "0250000002", "Z", Role.POSTMAN));
		list.add(new UserMessagePO(StaffChange.delete, "0250000001",null,null));
	}
	

	@Override
	public void insert(StaffChange operation, String id, String name, Role role) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserMessagePO> getAll() throws RemoteException {
		return list;
	}

}
