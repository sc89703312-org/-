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
	
	public ResultMessage addHall(HallPo po) throws RemoteException;
	public ResultMessage removeHall(String id) throws RemoteException;
	public ArrayList<HallPo> showHall() throws RemoteException;
	public String getLocation(String id) throws RemoteException;
	public void flushHalls() throws RemoteException;
	
	public String nextArrivalID(String hallID) throws RemoteException;
	public ResultMessage addHallArrival(ArrivalReceiptPO po)throws RemoteException;
	public ArrivalReceiptPO findHallArrival(String id)throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)throws RemoteException;
	public void approveHallArrival(String id)throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getApproveArrival() throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getSummitArrival() throws RemoteException;
	public void flushHallArrival() throws RemoteException;
	
	public String nextHallTransferID(String hallID) throws RemoteException;
	public ResultMessage addHallTransfer(HallTransferReceiptPO po)throws RemoteException;
	public HallTransferReceiptPO findHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer()throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)throws RemoteException;
	public void approveHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getApproveTransfer() throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getSummitTransfer() throws RemoteException;
	public void flushHallTransfer()throws RemoteException;
	
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
