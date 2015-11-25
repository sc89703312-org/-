package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.LogisticsPO;



public interface LogisticsDataService extends Remote{
	public ResultMessage insert(LogisticsPO po) throws RemoteException;
	public ResultMessage update(LogisticsPO po) throws RemoteException;
	public LogisticsPO find(String id) throws RemoteException;

	public ArrayList<LogisticsPO>  getAll() throws RemoteException;
	
	public void flush()throws RemoteException;
	
}
