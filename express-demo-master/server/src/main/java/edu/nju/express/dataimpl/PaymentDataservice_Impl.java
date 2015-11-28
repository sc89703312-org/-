package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.paymentdata.PaymentDao;
import edu.nju.express.data.paymentdata.PaymentDataTest;
import edu.nju.express.dataservice.Paymentdataservice;
import edu.nju.express.po.Paymentpo;





public class PaymentDataservice_Impl extends UnicastRemoteObject implements Paymentdataservice {

	
	PaymentDao paymentDao;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentDataservice_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	paymentDao = new PaymentDataTest("payment");
	
	}

	@Override
	public ResultMessage insert(Paymentpo po) throws RemoteException {
		// TODO Auto-generated method stub
		return paymentDao.insert(po);
		
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
	    return	paymentDao.delete(id);
		
	}

	@Override
	public ResultMessage update(String id,Paymentpo po) throws RemoteException {
		// TODO Auto-generated method stub
		return paymentDao.update(id, po);
	}

	@Override
	public Paymentpo find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return paymentDao.find(id);
	}

	@Override
	public ArrayList<Paymentpo> viewByHall(String number) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Prepares to view payments by hall");
		return paymentDao.viewByHall(number);
	}

	@Override
	public ArrayList<Paymentpo> viewByDate(String date) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Prepares to view payments by date");
		return paymentDao.viewByDate(date);
	}

	@Override
	public ArrayList<Paymentpo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Show all the po and the length is "+paymentDao.showAll().size());
		return paymentDao.showAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("data_impl does");
		paymentDao.flush();
	}

	@Override
	public ArrayList<Paymentpo> viewAllPaymentSubmitted()
			throws RemoteException {
		// TODO Auto-generated method stub
		return paymentDao.viewAllPaymentSubmitted();
	}

	@Override
	public ArrayList<String> viewAllOrderListByHall(String HallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return paymentDao.viewAllOrderListByHall(HallID);
	}
	
	

}
