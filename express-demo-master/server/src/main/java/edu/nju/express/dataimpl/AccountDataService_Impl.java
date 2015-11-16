package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.accountdata.AccountDao;
import edu.nju.express.data.accountdata.AccountFileDao;
import edu.nju.express.dataservice.accountdataservice;
import edu.nju.express.po.Accountpo;



public class AccountDataService_Impl extends UnicastRemoteObject implements accountdataservice{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	AccountDao accountDao;
	
	
	
	
	
	public AccountDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	
	accountDao = new AccountFileDao();
	
	
	}

	@Override
	public void insert(Accountpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Insert a new po");
		
		accountDao.insert(po);
		
	}

	@Override
	public Accountpo find(String date) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Prepare to find a po");
		
		
		
		return accountDao.find(date);
	}

	@Override
	public ArrayList<Accountpo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Prepare to get all po");
		
		
		
		return accountDao.getAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Flush");
		
		accountDao.flush();
		
	}

}
