package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserMessagePO;

/**
 * 人员变动申请的数据层接口
 * @author Dora
 * @version 2015-12-9 22:22:10
 */

public interface UserMessageDataService extends Remote{
	
	/**
	 * 插入一个人员变动申请的持久化对象
	 * @author Dora
	 * @param po
	 * @return 数据层操作是否有效
	 * @throws RemoteException
	 */
	public ResultMessage insert(UserMessagePO po) throws RemoteException;
	
	/**
	 * 删除一个人员变动申请的持久化对象
	 * @author Dora
	 * @param id
	 * @return 数据层操作是否有效
	 * @throws RemoteException
	 */
	public ResultMessage delete(String id) throws RemoteException;
	
	/**
	 * 查找人员变动申请的持久化对象
	 * @author Dora
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public UserMessagePO find(String id) throws RemoteException;
	
	/**
	 * 获得所有人员申请的持久化对象
	 * @author Dora
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserMessagePO> getAll() throws RemoteException;

	/**
	 * 将数据写入文件
	 * @author Dora
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
}
