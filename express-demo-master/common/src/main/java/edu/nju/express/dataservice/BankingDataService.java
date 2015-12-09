package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.BankingAccountPO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 23:25
 * 
 *  银行账户模块的数据层接口
 * 
 */

public interface BankingDataService extends Remote{

	/** 增加余额
	 * 
	 * @param name 账户名
	 * @param num 增加量
	 * @throws RemoteException
	 */
	public void income(String name, int num) throws RemoteException;
	
	/** 减少余额
	 * 
	 * @param name 账户名
	 * @param num 减少量
	 * @throws RemoteException
	 */
	public void expend(String name, int num) throws RemoteException;
	
	/** 修改账户名
	 * 
	 * @param newName
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyName(String newName, String name) throws RemoteException;
	
	/** 新增账户
	 * 
	 * @param name
	 * @throws RemoteException
	 */
	public void addAccount(String name) throws RemoteException;
	
	/** 真-新增账户
	 * 
	 * @param name
	 * @throws RemoteException
	 */
	public ResultMessage insert(BankingAccountPO po)throws RemoteException;
	
	/** 移除账户
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage removeAccount(String name) throws RemoteException;
	
	/** 获得所有账户
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankingAccountPO> getAccount() throws RemoteException;
	
	/** 序列化数据
	 * 
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
}
