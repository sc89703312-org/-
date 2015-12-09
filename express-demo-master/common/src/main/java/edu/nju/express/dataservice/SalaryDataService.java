package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 薪水制定的数据层接口
 * @author Dora
 * @version 2015-12-9 22:05:16
 */
public interface SalaryDataService extends Remote{

	/**
	 * 改变业务员薪水
	 * @author Dora
	 * @param salary
	 * @throws RemoteException
	 */
    public void setClerkSalary(double salary) throws RemoteException;
	/**
	 * 改变司机提成
	 * @author Dora
	 * @param wage
	 * @throws RemoteException
	 */
	public void setDriverWage(double wage) throws RemoteException;
	/**
	 * 改变快递员提成
	 * @author Dora
	 * @param wage
	 * @throws RemoteException
	 */
	public void setPostmanWage(double wage) throws RemoteException;
	/**
	 * 查询业务员月薪
	 * @author Dora
	 * @return 业务员月薪
	 * @throws RemoteException
	 */
	public double getClerkSalary()throws RemoteException;
	
	/**
	 * 查询司机提成
	 * @author Dora
	 * @return 司机提成
	 * @throws RemoteException
	 */
	public double getDriverWage()throws RemoteException;
	
	/**
	 * 查询快递员提成
	 * @author Dora
	 * @return　快递员提成
	 * @throws RemoteException
	 */
	public double getPostmanWage() throws RemoteException;
	
	/**
	 * 将薪水数据写入文件
	 * @author Dora
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
	
}
