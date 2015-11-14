package client.dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.po.logisticspo.LogisticsPO;

public interface LogisticsDataService extends Remote{
	public void insert(LogisticsPO po) throws RemoteException;
	public void update(LogisticsPO po) throws RemoteException;
	public LogisticsPO find(String id) throws RemoteException;
}
