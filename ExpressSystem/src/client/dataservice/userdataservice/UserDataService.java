package client.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.Role;
import client.po.userpo.UserPO;
import client.vo.uservo.UserVO;

public interface UserDataService extends Remote{
	
	public void insert(String id, String name, Role role,String password) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public void modify(String id, String name, Role role,String password) throws RemoteException;
	
	public UserPO find(String id) throws RemoteException;
	
	public ArrayList<UserPO> getAll() throws RemoteException;
	
}
