package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.po.UserMessagePO;



public interface UserMessageDataService extends Remote{
	
	public void insert(StaffChange operation, String id,String name,Role role) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public ArrayList<UserMessagePO> getAll() throws RemoteException;

}
