package edu.nju.express.log;

import java.awt.Component;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataservice.LogRecordDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.LogMessage;





public class LogController {

	

	public static final String logFilesName = null;
	static LogRecordDataService logRecordDataService = RMIHelper.getLogRecordDataService();

	
	
	public LogController() {
		// TODO Auto-generated constructor stub
	
	
		
	
	}
	
	
	
	
	public static void insertLog(LogMessage msg){
		try {
			logRecordDataService.insertLog(msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<LogMessage> viewAllMsg(){
		try {
			return logRecordDataService.viewAllLogs();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




	public static ArrayList<LogMessage> getLogsByDate(String date) {
		// TODO Auto-generated method stub
		try {
			return logRecordDataService.viewLogsByDate(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return null;
	}





}
