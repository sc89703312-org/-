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
		System.out.println("Prepares to get some po");
		return balanceDao.find(date);
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
		return balanceDao.getAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		balanceDao.flush();
	}

}
