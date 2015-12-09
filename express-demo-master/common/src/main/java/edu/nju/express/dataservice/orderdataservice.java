package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.OrderPO;




public interface orderdataservice extends Remote {
	
	/**插入一个订单的po对象
	 * @author guhan
	 * @param po
	 * @throws RemoteException
	 */
	public ResultMessage insert(OrderPO po)throws RemoteException;
	
	/**更新一个订单的PO对象
	 * @author guhan
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage update(OrderPO po)throws RemoteException;
	
	/**删除一个订单的po对象
	 * @author guhan
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delete(String id)throws RemoteException;
	
	/**按订单号返回一个订单po对象
	 * @author guhan
	 * @param id
	 * @return 对应订单的po对象
	 * @throws RemoteException
	 */
	public OrderPO find(String id)throws RemoteException;
	
	/**获取所有订单的po对象
	 * @author guhan
	 * @return 所有订单的po对象
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO>  getAll() throws RemoteException;
	
	/**将orderpo全部写入
	 * @author guhan
	 * @throws RemoteException
	 */
	public void flush()throws RemoteException;
	
	/**给对应订单添加物流信息
	 * @author guhan
	 * @param spot 当前位置信息，添加到订单的历史轨迹里
	 * @param id
	 * @throws RemoteException
	 */
	public void addHistory(String spot,String id)throws RemoteException;
	
	/**订单被分配后， 设置订单po属性里的派件员
	 * @author guhan
	 * @param name 派件员编号
	 * @param id
	 * @throws RemoteException
	 */
	public void setDeliver(String name,String id)throws RemoteException;
	
	/**设置快件的到达状态，已到达或未到达
	 * @author guhan
	 * @param arrivalState YES ,  NO
	 * @param id
	 * @throws RemoteException
	 */
	public void setArrivalState(ArrivalState arrivalState,String id) throws RemoteException;
	
}
