package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.balancedata.BalanceDao;
import edu.nju.express.data.balancedata.BalanceDataTest;
import edu.nju.express.data.balancedata.BalanceFileDao;
import edu.nju.express.dataservice.balancedataservice;
import edu.nju.express.po.Balancepo;



public class BalanceDataService_Impl extends UnicastRemoteObject implements balancedataservice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BalanceDao balanceDao  ;
	
	
	public BalanceDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	balanceDao = new BalanceDataTest("balance");
	}

	@Override
	public void insert(Balancepo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A po has been inserted");
		balanceDao.insert(po);
	}

	@Override
	public ArrayList<Balancepo> find(String date) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Prepares to get some po");
		return balanceDao.findByDate(date);
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to delete a po");
		balanceDao.delete(id);
	}

	@Override
	public void update(Balancepo po,String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to update a po");
		balanceDao.update(po, id);
	}

	@Override
	public ArrayList<Balancepo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Show All");
		return balanceDao.showAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		balanceDao.flush();
	}

}
