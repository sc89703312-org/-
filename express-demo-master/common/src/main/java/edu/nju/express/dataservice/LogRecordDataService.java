package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.ws.LogicalMessage;

import edu.nju.express.po.LogMessage;


/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:24:54
 * 
 * 对日志进行数据记录
 */

public interface LogRecordDataService extends Remote {

	/**
	 * 插入一条新的日志记录
	 * @param msg
	 * @throws RemoteException
	 */
	public void insertLog(LogMessage msg) throws RemoteException;
	
	
	/**
	 * 
	 * @return 获取当前所有的日志列表
	 * @throws RemoteException
	 */
	public ArrayList<LogMessage> viewAllLogs () throws RemoteException;
	
	
	/**
	 * 
	 * @param date
	 * @return 根据日期获取所属的日志
	 * @throws RemoteException
	 */
	public ArrayList<LogMessage> viewLogsByDate(String date)  throws RemoteException;
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flush()throws RemoteException;
}
