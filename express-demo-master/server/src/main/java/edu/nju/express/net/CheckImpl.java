package edu.nju.express.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CheckImpl extends UnicastRemoteObject implements CheckService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void check() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
