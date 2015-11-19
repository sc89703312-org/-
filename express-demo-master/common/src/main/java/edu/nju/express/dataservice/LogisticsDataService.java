package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.express.po.LogisticsPO;



public interface LogisticsDataService extends Remote{
	public void insert(LogisticsPO po) throws RemoteException;
	public void update(LogisticsPO po) throws RemoteException;
	public LogisticsPO find(String id) throws RemoteException;

	public ArrayList<LogisticsPO>  getAll() throws RemoteException;
	
	
}
