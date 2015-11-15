package client.dataservice.bankingdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.bankingpo.BankingAccountPO;

public interface BankingDataService extends Remote{

	public void income(String name, int num) throws RemoteException;
	public void expend(String name, int num) throws RemoteException;
	public void modifyName(String newName, String name) throws RemoteException;
	public void addAccount(String name) throws RemoteException;
	public void removeAccount(String name) throws RemoteException;
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException;
	
}