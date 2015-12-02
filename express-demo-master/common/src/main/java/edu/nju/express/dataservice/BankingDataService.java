package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.BankingAccountPO;



public interface BankingDataService extends Remote{

	public void income(String name, int num) throws RemoteException;
	public void expend(String name, int num) throws RemoteException;
	public ResultMessage modifyName(String newName, String name) throws RemoteException;
	public void addAccount(String name) throws RemoteException;
	public ResultMessage insert(BankingAccountPO po)throws RemoteException;
	public ResultMessage removeAccount(String name) throws RemoteException;
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException;
	public void flush() throws RemoteException;
}
