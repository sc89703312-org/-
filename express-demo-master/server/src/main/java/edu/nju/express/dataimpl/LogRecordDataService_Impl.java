package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.logdata.LogDao;
import edu.nju.express.data.logdata.LogFileDao;
import edu.nju.express.dataservice.LogRecordDataService;
import edu.nju.express.po.LogMessage;

public class LogRecordDataService_Impl extends UnicastRemoteObject implements LogRecordDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	LogDao logDao;
	
	
	public LogRecordDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		logDao = new LogFileDao("log");
	}

	@Override
	public void insertLog(LogMessage msg) throws RemoteException {
		// TODO Auto-generated method stub
		logDao.insertLog(msg);
	}

	@Override
	public ArrayList<LogMessage> viewAllLogs() throws RemoteException {
		// TODO Auto-generated method stub
		return logDao.viewAllLogs();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		logDao.flush();
	}

	@Override
	public ArrayList<LogMessage> viewLogsByDate(String date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return logDao.viewLogsByDate(date);
	}

}
