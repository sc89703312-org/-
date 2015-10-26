package server.dataservice.balancedataservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.balancedata.BalanceDao;
import server.data.balancedata.Impl.BalanceFileDao;
import client.dataservice.balancedataservice.balancedataservice;
import client.po.balancepo.Balancepo;


public class BalanceDataService_Impl extends UnicastRemoteObject implements balancedataservice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BalanceDao balanceDao  ;
	
	
	public BalanceDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	balanceDao = new BalanceFileDao();
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
		return null;
	}

	@Override
	public void delete(Balancepo po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Balancepo po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Balancepo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Show All");
		return balanceDao.getAll();
	}

}
