package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.HallTransferReceiptPO;

public interface HallDataService extends Remote{
	
	/**新增营业厅写入数据层
	 * @author guhan
	 * @param po 营业厅信息持久化对象
	 * @throws RemoteException
	 */
	public ResultMessage addHall(HallPo po) throws RemoteException;
	
	/**删除营业厅的数据
	 * @author guhan
	 * @param id 营业厅id
	 * @throws RemoteException
	 */
	public ResultMessage removeHall(String id) throws RemoteException;
	
	/**从data中读取所有营业厅信息
	 * @author guhan
	 * @return 营业厅po的list
	 * @throws RemoteException
	 */
	public ArrayList<HallPo> showHall() throws RemoteException;
	
	/**获得当前营业厅所在位置
	 * @author guhan
	 * @param id
	 * @return 位置信息
	 * @throws RemoteException
	 */
	public String getLocation(String id) throws RemoteException;
	
	/**把营业厅信息写入序列化文件
	 * @author guhan
	 * @throws RemoteException
	 */
	public void flushHalls() throws RemoteException;
	
	/**编号++
	 * @author guhan
	 * @param hallID 营业厅编号
	 * @return 下一张到达单编号
	 * @throws RemoteException
	 */
	public String nextArrivalID(String hallID) throws RemoteException;
	
	/**将到达单信息写入data
	 * @author guhan
	 * @param po 
	 * @throws RemoteException
	 */
	public ResultMessage addHallArrival(ArrivalReceiptPO po)throws RemoteException;
	
	/**按到达单编号返回到达单信息
	 * @author guhan
	 * @param id 
	 * @return 对应的到达单的PO
	 * @throws RemoteException
	 */
	public ArrivalReceiptPO findHallArrival(String id)throws RemoteException;
	
	/**获得所有到达单信息
	 * @author guhan
	 * @return 到达单信息的一个list
	 * @throws RemoteException
	 */
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException;
	
	/**获取一个营业厅的到达单信息
	 * @author guhan
	 * @param hallID
	 * @return 到达单信息的一个list
	 * @throws RemoteException
	 */
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)throws RemoteException;
	
	/**审批到达单
	 * @author guhan
	 * @param id
	 * @throws RemoteException
	 */
	public void approveHallArrival(String id)throws RemoteException;
	
	/**获得已经审批过的到达单信息
	 * @author guhan
	 * @return 已经审批过的到达单list
	 * @throws RemoteException
	 */
	public ArrayList<ArrivalReceiptPO> getApproveArrival() throws RemoteException;
	
	/**获得已提交的到达单信息
	 * @author guhan
	 * @return 已提交的到达单list
	 * @throws RemoteException
	 */
	public ArrayList<ArrivalReceiptPO> getSummitArrival() throws RemoteException;
	
	/**把到达单信息写入序列化文件
	 * @author guhan
	 * @throws RemoteException
	 */
	public void flushHallArrival() throws RemoteException;
	
	/*
	 * 下面为相似功能
	 */
	
	/*装车单*/
	public String nextHallTransferID(String hallID) throws RemoteException;
	public ResultMessage addHallTransfer(HallTransferReceiptPO po)throws RemoteException;
	public HallTransferReceiptPO findHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer()throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)throws RemoteException;
	public void approveHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getApproveTransfer() throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getSummitTransfer() throws RemoteException;
	public void flushHallTransfer()throws RemoteException;
	
	/*派件单*/
	public String nextDeliverID(String hallID) throws RemoteException;
	public ResultMessage addHallDeliver(DeliverReceiptPO po) throws RemoteException;
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException;
	public ArrayList<DeliverReceiptPO> getAllHallDeliver()throws RemoteException;
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)throws RemoteException;
	public void approveHallDeliver(String id)throws RemoteException;
	public ArrayList<DeliverReceiptPO> getApproveDeliver() throws RemoteException;
	public ArrayList<DeliverReceiptPO> getSummitDeliver() throws RemoteException;
	public void flushHallDeliver()throws RemoteException;
 	
}
