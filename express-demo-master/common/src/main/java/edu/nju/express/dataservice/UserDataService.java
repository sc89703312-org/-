package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.UserPO;



public interface UserDataService extends Remote{
	
	public int insert(UserPO po) throws RemoteException;
	
	public int delete(String id) throws RemoteException;
	
	public int modify(UserPO po) throws RemoteException;
	
	public UserPO find(String id) throws RemoteException;
	
	public ArrayList<UserPO> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
}
