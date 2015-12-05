package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.express.po.LoginInfo;

public interface LoginInfoDataService extends Remote {

	public void insert(LoginInfo info)throws RemoteException;
}
