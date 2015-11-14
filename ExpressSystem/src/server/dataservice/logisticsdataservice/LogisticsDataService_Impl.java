package server.dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client.dataservice.logisticsdataservice.LogisticsDataService;
import client.po.logisticspo.LogisticsPO;

public class LogisticsDataService_Impl extends UnicastRemoteObject implements LogisticsDataService{

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
