package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Accountpo;




public interface accountdataservice extends Remote {

	
	public ResultMessage insert(Accountpo po) throws RemoteException;
	
	public Accountpo find(String date) throws RemoteException;
	
	public ArrayList<Accountpo> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
	
}
