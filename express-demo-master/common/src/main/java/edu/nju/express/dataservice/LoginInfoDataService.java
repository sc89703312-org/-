package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.LoginInfo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:23:25
 * 
 * 对登陆信息进行记录 便于在服务器终端加以显示以及设置登陆信息身份
 */


public interface LoginInfoDataService extends Remote {

	/**
	 * 插入一条登陆信息
	 * @param info
	 * @throws RemoteException
	 */
	public void insert(LoginInfo info)throws RemoteException;
	
	/**
	 * 
	 * @return 获取所有的登陆信息
	 * @throws RemoteException
	 */
	public  ArrayList<LoginInfo> getAll() throws RemoteException;
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
}
