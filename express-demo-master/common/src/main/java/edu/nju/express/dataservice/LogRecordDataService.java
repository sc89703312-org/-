package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.ws.LogicalMessage;

import edu.nju.express.po.LogMessage;

public interface LogRecordDataService extends Remote {

	
	public void insertLog(LogMessage msg) throws RemoteException;
	
	public ArrayList<LogMessage> viewAllLogs () throws RemoteException;
	
	public ArrayList<LogMessage> viewLogsByDate(String date)  throws RemoteException;
	
	public void flush()throws RemoteException;
}
