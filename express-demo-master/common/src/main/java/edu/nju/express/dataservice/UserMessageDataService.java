package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserMessagePO;



public interface UserMessageDataService extends Remote{
	
	public ResultMessage insert(UserMessagePO po) throws RemoteException;
	
	public ResultMessage delete(String id) throws RemoteException;
	
	public UserMessagePO find(String id) throws RemoteException;
	
	public ArrayList<UserMessagePO> getAll() throws RemoteException;

	public void flush() throws RemoteException;
}
