package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.po.UserPO;



public interface UserDataService extends Remote{
	
	public void insert(String id, String name, Role role,String password) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public void modify(String id, String name, Role role,String password) throws RemoteException;
	
	public UserPO find(String id) throws RemoteException;
	
	public ArrayList<UserPO> getAll() throws RemoteException;
	
}
