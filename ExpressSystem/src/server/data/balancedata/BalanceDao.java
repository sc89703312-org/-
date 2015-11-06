package server.data.balancedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.balancepo.Balancepo;


public interface BalanceDao {

    public void insert(Balancepo po) ;
	
	public ArrayList<Balancepo > find(String date) ;
	
	public void delete(String id) ;
	
	public void update(Balancepo po,String id);
	
	public ArrayList<Balancepo> getAll() ;
	
	public void flush();
}
