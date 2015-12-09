package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Paymentpo;


/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:26:19
 * 
 * 用于收款单的插入 删除 和按各种方法进行查找
 */

public interface Paymentdataservice extends Remote{

	/**
	 * 
	 * @param po
	 * @return 插入一个收款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage insert(Paymentpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 删除一个收款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage delete(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @param po
	 * @return 更新一个收款单是否合法
	 * @throws RemoteException
	 */
	public ResultMessage update(String id,Paymentpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 根据ID查询收款单
	 * @throws RemoteException
	 */
	public Paymentpo find(String id) throws RemoteException;
	
	
	/**
	 * 
	 * @param postManID
	 * @return 计算快递员收入
	 * @throws RemoteException
	 */
	public double caculatePostManSalary(String postManID) throws RemoteException;
	
	/**
	 * 
	 * @param number
	 * @return 根据营业厅编号查看收款单
	 * @throws RemoteException
	 */
	public ArrayList<Paymentpo> viewByHall(String number) throws RemoteException;
	
	/**
	 * 
	 * @param date
	 * @return 根据日期查看收款单
	 * @throws RemoteException
	 */
	public ArrayList<Paymentpo> viewByDate(String date) throws RemoteException;
	
	/**
	 * 
	 * @return 获取所有未审批的收款单
	 * @throws RemoteException
	 */
	public ArrayList<Paymentpo> viewAllPaymentSubmitted() throws RemoteException;
	
	
	
	/**
	 * 
	 * @return 获取所有收款单
	 * @throws RemoteException
	 */
	public ArrayList<Paymentpo> getAll() throws RemoteException;
	
	
	/**
	 * 
	 * @param HallID
	 * @return 根据营业厅编号返回订单列表
	 * @throws RemoteException
	 */
	public ArrayList<String> viewAllOrderListByHall(String HallID)throws RemoteException;
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
}
