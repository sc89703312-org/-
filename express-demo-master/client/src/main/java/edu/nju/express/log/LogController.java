package edu.nju.express.log;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataservice.LogRecordDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.LogMessage;





public class LogController {

	

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
	
	
	public ArrayList<LogMessage> viewAllMsg(){
		try {
			return logRecordDataService.viewAllLogs();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
