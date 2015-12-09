package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:30:42
 * 
 * 对车辆和司机进行数据层的增删改查等
 */


public interface vehicledataservice extends Remote {

	
	/**
	 * 
	 * @param po
	 * @return 新增一辆车是否合法
	 * @throws RemoteException
	 */
	public ResultMessage insertCar(Carpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 删除一辆车是否合法
	 * @throws RemoteException
	 */
	public ResultMessage deleteCar(String id) throws RemoteException;
	
	/**
	 * 
	 * @param number
	 * @param po
	 * @return 更新一辆车是否合法
	 * @throws RemoteException
	 */
	public ResultMessage updateCar(String number,Carpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 一辆车的PO
	 * @throws RemoteException
	 */
	public Carpo findCar(String id) throws RemoteException;
	
	
	/**
	 * 
	 * @param po
	 * @return 新增一个司机是否合法
	 * @throws RemoteException
	 */
	public ResultMessage insertDri(Driverpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 删除一个司机是否合法
	 * @throws RemoteException
	 */
	public ResultMessage deleteDri(String id) throws RemoteException;
	
	/**
	 * 
	 * @param number
	 * @param po
	 * @return 更新一个司机是否合法
	 * @throws RemoteException
	 */
	public ResultMessage updateDri(String number ,Driverpo po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 查找一个司机是否合法
	 * @throws RemoteException
	 */
	public Driverpo findDri(String id) throws RemoteException;
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flushCars() throws RemoteException;
	
	
	
	/**
	 * 写入数据流
	 * @throws RemoteException
	 */
	public void flushDrivers() throws RemoteException;
	
	
	/**
	 * 
	 * @return 获取所有车辆
	 * @throws RemoteException
	 */
	public ArrayList<Carpo> getAllCars() throws RemoteException;
	
	
	/**
	 * 
	 * @return 获取所有司机
	 * @throws RemoteException
	 */
	public ArrayList<Driverpo> getAllDrivers() throws RemoteException;
}
