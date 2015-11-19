package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.orderdata.OrderDao;
import edu.nju.express.data.orderdata.OrderFileDao;
import edu.nju.express.dataservice.orderdataservice;
import edu.nju.express.po.OrderPO;

public class OrderDataService_Impl extends UnicastRemoteObject implements orderdataservice{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderDao orderDao;

	protected OrderDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		orderDao = new OrderFileDao();
	}
	
	
	@Override
	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.insert(po);
	}


	@Override
	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.update(po);
	}


	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.delete(id);
	}


	@Override
	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.find(id);
	}
	
	@Override
	public ArrayList<OrderPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.getAll();
	}
	
	/**
	 * 新增方法
	 * flush
	 */
	public void flush() throws RemoteException{
		orderDao.flush();
	}
	

}


	
