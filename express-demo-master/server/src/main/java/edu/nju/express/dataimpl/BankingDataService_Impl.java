package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.BankingDataService;
import edu.nju.express.po.BankingAccountPO;



public class BankingDataService_Impl implements BankingDataService{

	@Override
	public void income(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void expend(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modifyName(String newName, String name) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage removeAccount(String name) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
