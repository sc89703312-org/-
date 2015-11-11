package server.dataservice.bankingdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.dataservice.bankingdataservice.BankingDataService;
import client.po.bankingpo.BankingAccountPO;

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
	public void modifyName(String newName, String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
