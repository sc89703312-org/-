package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.express.data.logisticsdata.LogisticsDao;
import edu.nju.express.dataservice.LogisticsDataService;
import edu.nju.express.po.LogisticsPO;



public class LogisticsDataService_Impl extends UnicastRemoteObject implements LogisticsDataService{

	LogisticsDao logisticsDao;
	protected LogisticsDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LogisticsPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
