package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserPO;



public interface UserDataService extends Remote{
	
	public ResultMessage insert(UserPO po) throws RemoteException;
	
	public ResultMessage delete(String id) throws RemoteException;
	
	public ResultMessage modify(UserPO po) throws RemoteException;
	
	public UserPO find(String id) throws RemoteException;
	
	public ArrayList<UserPO> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
}
