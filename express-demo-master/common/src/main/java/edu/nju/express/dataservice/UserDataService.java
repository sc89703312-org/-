package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserPO;

/**
 * 账号的数据层接口
 * @author Dora
 * @version 2015-12-9 22:11:17
 */

public interface UserDataService extends Remote{
	
	/**
	 * 插入一个账号持久化对象
	 * @author Dora
	 * @param po
	 * @return 数据层操作是否有效
	 * @throws RemoteException
	 */
	public ResultMessage insert(UserPO po) throws RemoteException;
	
	/**
	 * 删除一个账号持久化对象
	 * @author Dora
	 * @param id
	 * @return 数据层操作是否有效
	 * @throws RemoteException
	 */
	public ResultMessage delete(String id) throws RemoteException;
	
	/**
	 * 修改一个账号持久化对象
	 * @author Dora
	 * @param po
	 * @return 数据层操作是否有效
	 * @throws RemoteException
	 */
	public ResultMessage modify(UserPO po) throws RemoteException;
	
	/**
	 * 查询一个账号
	 * @author Dora
	 * @param id
	 * @return 账号的持久化对象
	 * @throws RemoteException
	 */
	public UserPO find(String id) throws RemoteException;
	
	/**
	 * 获得所有账号
	 * @author Dora
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAll() throws RemoteException;
	
	/**
	 * 将数据写入文件
	 * @author Dora
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
}
