package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.express.dataservice.LoginInfoDataService;
import edu.nju.express.po.LoginInfo;

public class LoginInfoDataService_Impl extends UnicastRemoteObject implements LoginInfoDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInfoDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(LoginInfo info) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
