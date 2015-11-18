package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.UserMessagePO;



public interface UserMessageDataService extends Remote{
	
	public int insert(UserMessagePO po) throws RemoteException;
	
	public int delete(String id) throws RemoteException;
	
	public UserMessageDataService find(String id) throws RemoteException;
	
	public ArrayList<UserMessagePO> getAll() throws RemoteException;

	public void flush() throws RemoteException;
}
