package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.LoginInfo;

public interface LoginInfoDataService extends Remote {

	public void insert(LoginInfo info)throws RemoteException;
	
	public ArrayList<LoginInfo> getAll() throws RemoteException;
}
