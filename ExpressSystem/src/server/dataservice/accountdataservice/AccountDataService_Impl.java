package server.dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.accountdata.AccountDao;
import server.data.accountdata.Impl.AccountFileDao;
import client.dataservice.accountdataservice.accountdataservice;
import client.po.accountpo.Accountpo;

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
