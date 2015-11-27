package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Balancepo;
import edu.nju.express.vo.Balancevo;




public interface balancedataservice extends Remote {

	public ResultMessage insert(Balancepo po) throws RemoteException;
	
	public ArrayList<Balancepo> find(String date) throws RemoteException;
	
	public Balancepo findById(String id) throws RemoteException;
	
	public ResultMessage delete(String id) throws RemoteException;
	
	public ResultMessage update(Balancepo po,String id)throws RemoteException;
	
	public ArrayList<Balancepo> getAll() throws RemoteException;
	
	public void flush() throws RemoteException;
	
	public ArrayList<Balancepo> viewAllCostSubmitted() throws RemoteException;
	

}
