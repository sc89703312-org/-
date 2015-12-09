package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.accountdata.AccountDao;
import edu.nju.express.data.accountdata.AccountDataTest;
import edu.nju.express.dataservice.accountdataservice;
import edu.nju.express.po.Accountpo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日23:50:11
 * 
 * 对账目信息进行读写操作
 */

public class AccountDataService_Impl extends UnicastRemoteObject implements accountdataservice{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 账目数据接口 */
	AccountDao accountDao;
	
	
	
	
	
	public AccountDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	
	accountDao = new AccountDataTest("account");
	
	
	}

	/**
	 * @author lenovo
	 * @version 2015年12月9日23:53:20
	 * @return 对存储数据文件进行插入
	 */
	@Override
	public ResultMessage insert(Accountpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Insert a new po");
		
	     return	accountDao.insert(po);
		
	}

	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日23:53:20
	 * @return 对存储数据文件进行查找
	 */
	@Override
	public Accountpo find(String date) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Prepare to find a po");
		
		
		
		return accountDao.find(date);
	}

	
	/**
	 * @author lenovo
	 * @version 2015年12月9日23:53:20
	 * @return 对存储数据文件进行获取
	 */
	@Override
	public ArrayList<Accountpo> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Prepare to get all po");
		
		
		
		return accountDao.showAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		

		accountDao.flush();
		
	}

}
