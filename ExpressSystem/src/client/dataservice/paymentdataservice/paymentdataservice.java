package client.dataservice.paymentdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.paymentpo.Paymentpo;


public interface Paymentdataservice extends Remote{

	public void insert(Paymentpo po) throws RemoteException;
	public void delete(String id) throws RemoteException;
	public void update(Paymentpo po) throws RemoteException;
	public Paymentpo find(String id) throws RemoteException;
	
	public ArrayList<Paymentpo> viewByHall(String number) throws RemoteException;
	public ArrayList<Paymentpo> viewByDate(String date) throws RemoteException;
	
	
	public ArrayList<Paymentpo> getAll() throws RemoteException;
	
	
	public void flush() throws RemoteException;
}
