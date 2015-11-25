package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.OrderPO;




public interface orderdataservice extends Remote {
	public ResultMessage insert(OrderPO po)throws RemoteException;
	
	public ResultMessage update(OrderPO po)throws RemoteException;
	
	public ResultMessage delete(String id)throws RemoteException;
	
	public OrderPO find(String id)throws RemoteException;
	
	public ArrayList<OrderPO>  getAll() throws RemoteException;
	
	public void flush()throws RemoteException;
}
