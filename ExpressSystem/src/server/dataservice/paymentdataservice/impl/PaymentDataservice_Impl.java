package server.dataservice.paymentdataservice.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.paymentdata.PaymentDao;
import server.data.paymentdata.impl.PaymentFileDao;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.po.paymentpo.Paymentpo;



public class PaymentDataservice_Impl extends UnicastRemoteObject implements Paymentdataservice {

	
	PaymentDao paymentDao;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentDataservice_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	paymentDao = new PaymentFileDao();
	
	}

	@Override
	public void insert(Paymentpo po) throws RemoteException {
		// TODO Auto-generated method stub
		paymentDao.insert(po);
		System.out.println("A po has been inserted");
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		paymentDao.delete(id);
		System.out.println("A po has been deleted");
	}

	@Override
	public void update(Paymentpo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A po has been updated");
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
		System.out.println("Show all the po and the length is "+paymentDao.getAll().size());
		return paymentDao.getAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		paymentDao.flush();
	}
	
	

}
