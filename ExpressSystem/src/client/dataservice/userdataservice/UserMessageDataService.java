package client.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.Role;
import client.po.StaffChange;
import client.po.userpo.UserMessagePO;

public interface UserMessageDataService extends Remote{
	
	public void insert(StaffChange operation, String id,String name,Role role) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public ArrayList<UserMessagePO> getAll() throws RemoteException;

}
