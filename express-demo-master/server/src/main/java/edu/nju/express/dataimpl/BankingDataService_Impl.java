package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.bankingdata.BankingDao;
import edu.nju.express.data.bankingdata.BankingFileDao;
import edu.nju.express.dataservice.BankingDataService;
import edu.nju.express.po.BankingAccountPO;



public class BankingDataService_Impl extends UnicastRemoteObject implements BankingDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BankingDao bankingDao;
	
	public BankingDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		bankingDao = new BankingFileDao("banking");
	}


	@Override
	public void income(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankingDao.income(name, num);
	}

	@Override
	public void expend(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankingDao.expend(name, num);
	}

	@Override
	public ResultMessage modifyName(String newName, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return bankingDao.modify(newName, name);
	}

	@Override
	public void addAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
		bankingDao.add(new BankingAccountPO(name));
		
	}

	@Override
	public ResultMessage removeAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub		
		return bankingDao.remove(name);
	}

	@Override
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return bankingDao.getAll();
	}

}
