package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.balancedata.BalanceDao;
import edu.nju.express.data.balancedata.BalanceDataTest;
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
	public ResultMessage insert(Balancepo po) throws RemoteException {
		// TODO Auto-generated method stub
		
		return balanceDao.insert(po);
	}

	@Override
	public ArrayList<Balancepo> find(String date) throws RemoteException {
		// TODO Auto-generated method stub
		

		return balanceDao.findByDate(date);
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return balanceDao.delete(id);
	}

	@Override
	public ResultMessage update(Balancepo po,String id) throws RemoteException {
		// TODO Auto-generated method stub
	
		return balanceDao.update(po, id);
	}

	@Override
	public ArrayList<Balancepo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		
		return balanceDao.showAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		balanceDao.flush();
	}

	@Override
	public ArrayList<Balancepo> viewAllCostSubmitted() throws RemoteException {
		// TODO Auto-generated method stub
		return balanceDao.viewAllCostSubmitted();
	}

	@Override
	public Balancepo findById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return balanceDao.findById(id);
	}

	@Override
	public ArrayList<Balancepo> getCostByDate() throws RemoteException {
		// TODO Auto-generated method stub
		return balanceDao.getCostByDate();
	}



}
