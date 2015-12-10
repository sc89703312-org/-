package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Balancepo;
import edu.nju.express.vo.Balancevo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:19:47
 * 
 * 用于付款单的新建 查找 删除等
 */


public interface balancedataservice extends Remote {

	/**
	 * 
	 * @param po
	 * @return 新建一个付款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage insert(Balancepo po) throws RemoteException;
	
	
	/**
	 * 
	 * @param date
	 * @return 根据日期查找所有的付款单
	 * @throws RemoteException
	 */
	public ArrayList<Balancepo> find(String date) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 根据日期返回单个付款单
	 * @throws RemoteException
	 */
	public Balancepo findById(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 根据ID删除付款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage delete(String id) throws RemoteException;
	
	
	/**
	 * 
	 * @param po
	 * @param id
	 * @return 根据ID和付款单判断更新付款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage update(Balancepo po,String id)throws RemoteException;
	
	/**
	 * 
	 * @return 获取所有的付款单
	 * @throws RemoteException
	 */
	public ArrayList<Balancepo> getAll() throws RemoteException;
	
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
	
	/**
	 * 
	 * @return 获取所有未审批的付款单
	 * @throws RemoteException
	 */
	public ArrayList<Balancepo> viewAllCostSubmitted() throws RemoteException;
	

	
	public ArrayList<Balancepo> getCostByDate() throws RemoteException;
}
