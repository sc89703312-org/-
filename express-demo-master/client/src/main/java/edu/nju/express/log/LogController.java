package edu.nju.express.log;

import java.awt.Component;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataservice.LogRecordDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.LogMessage;
import static edu.nju.express.init.RMIHelper.logRecordDataService;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:53:42
 * 
 * 记录主要操作日志
 */



public class LogController {

	

	public static final String logFilesName = null;

	
	
	public LogController() {
		// TODO Auto-generated constructor stub
	
	
		
	
	}
	
	
	
	/**
	 * 
	 * @param msg
	 * 插入日志信息
	 */
	public static void insertLog(LogMessage msg){
		try {
			logRecordDataService.insertLog(msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return 日志列表
	 */
	public static ArrayList<LogMessage> viewAllMsg(){
		try {
			return logRecordDataService.viewAllLogs();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



/**
 * 
 * @param date
 * @return 根据日期返回的日志列表
 */
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
