package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.dataservice.LoginInfoDataService;
import edu.nju.express.po.LoginInfo;

public class LoginInfoDataService_Impl extends UnicastRemoteObject implements LoginInfoDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	ArrayList<LoginInfo> infos;
	
	
	
	public LoginInfoDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		
		infos = new ArrayList<LoginInfo>();
		
		
	}

	@Override
	public void insert(LoginInfo info) throws RemoteException {
		// TODO Auto-generated method stub
		infos.add(info);
		
		ArrayList<LoginInfo> temp =getAll();
		
		System.out.println("Now the server has "+temp.size()+" login records");
		for(LoginInfo h:temp)
			System.out.println(h.getInfo());
		}
	
	
	@Override
	public ArrayList<LoginInfo> getAll()throws RemoteException{
		return infos;
	}

}
