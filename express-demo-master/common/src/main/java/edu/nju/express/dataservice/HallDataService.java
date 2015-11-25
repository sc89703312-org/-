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
	public void flushHalls() throws RemoteException;
	
	public ResultMessage addHallArrival(ArrivalReceiptPO po)throws RemoteException;
	public ResultMessage removeHallArrival(String id)throws RemoteException;
	public ArrivalReceiptPO findHallArrival(String id)throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException;
	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list)throws RemoteException;
	public void flushHallArrival() throws RemoteException;
	
	public ResultMessage addHallTransfer(HallTransferReceiptPO po)throws RemoteException;
	public ResultMessage removeHallTransfer(String id)throws RemoteException;
	public HallTransferReceiptPO findHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer()throws RemoteException;
	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list)throws RemoteException;
	public void flushHallTransfer()throws RemoteException;
	
	public ResultMessage addHallDeliver(DeliverReceiptPO po) throws RemoteException;
	public ResultMessage removeHallDeliver(String id)throws RemoteException;
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException;
	public ArrayList<DeliverReceiptPO> getAllHallDeliver()throws RemoteException;
	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list)throws RemoteException;
	public void flushHallDeliver()throws RemoteException;
}
