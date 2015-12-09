package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Accountpo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:17:48
 * 
 * 用于远程实现对账目的增加和查找
 */


public interface accountdataservice extends Remote {

	/**
	 * 
	 * @param po
	 * @return ResultMessage  新增账目是否合法
	 * @throws RemoteException
	 */
	public ResultMessage insert(Accountpo po) throws RemoteException;
	
	/**
	 * 
	 * @param date
	 * @return 账目信息
	 * @throws RemoteException
	 */
	public Accountpo find(String date) throws RemoteException;
	
	/**
	 * 
	 * @return 获取所有的账目信息
	 * @throws RemoteException
	 */
	public ArrayList<Accountpo> getAll() throws RemoteException;
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
	
}
