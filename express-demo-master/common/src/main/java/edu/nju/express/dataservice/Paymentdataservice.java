package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.Paymentpo;




public interface Paymentdataservice extends Remote{

	public void insert(Paymentpo po) throws RemoteException;
	public void delete(String id) throws RemoteException;
	public void update(String id,Paymentpo po) throws RemoteException;
	public Paymentpo find(String id) throws RemoteException;
	
	public ArrayList<Paymentpo> viewByHall(String number) throws RemoteException;
	public ArrayList<Paymentpo> viewByDate(String date) throws RemoteException;
	
	
	public ArrayList<Paymentpo> getAll() throws RemoteException;
	
	
	public void flush() throws RemoteException;
}
