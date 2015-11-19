package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.OrderPO;




public interface orderdataservice extends Remote {
	public void insert(OrderPO po)throws RemoteException;
	
	public void update(OrderPO po)throws RemoteException;
	
	public void delete(String id)throws RemoteException;
	
	public OrderPO find(String id)throws RemoteException;
	
	public ArrayList<OrderPO>  getAll() throws RemoteException;
	
}
