package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.ResultMessage;
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

	public OrderDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		orderDao = new OrderFileDao("order");
	}
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#insert(edu.nju.express.po.OrderPO)
	 */
	@Override
	public ResultMessage insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.insert(po);
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#update(edu.nju.express.po.OrderPO)
	 */
	@Override
	public ResultMessage update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.update(po);
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.delete(id);
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#find(java.lang.String)
	 */
	@Override
	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.find(id);
	}
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#getAll()
	 */
	@Override
	public ArrayList<OrderPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return orderDao.showAll();
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#flush()
	 */
	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.flush();
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#addHistory(java.lang.String, java.lang.String)
	 */
	@Override
	public void addHistory(String spot,String id) throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.addHistory(spot, id);
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#setDeliver(java.lang.String, java.lang.String)
	 */
	@Override
	public void setDeliver(String name,String id) throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.setDeliver(name, id);
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.orderdataservice#setArrivalState(edu.nju.express.common.ArrivalState, java.lang.String)
	 */
	@Override
	public void setArrivalState(ArrivalState arrivalState,String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		orderDao.setArrivalState(arrivalState, id);
	}
	
	
	

}


	
