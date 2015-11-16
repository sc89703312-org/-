package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.Balancepo;




public interface balancedataservice extends Remote {

	public void insert(Balancepo po) throws RemoteException;
	
	public ArrayList<Balancepo > find(String date) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	public void update(Balancepo po,String id)throws RemoteException;
	
	public ArrayList<Balancepo> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
}
