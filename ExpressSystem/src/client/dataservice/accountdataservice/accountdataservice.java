package client.dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.accountpo.Accountpo;


public interface accountdataservice extends Remote {

	
	public void insert(Accountpo po) throws RemoteException;
	
	public Accountpo find(String date) throws RemoteException;
	
	public ArrayList<Accountpo> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
	
}
