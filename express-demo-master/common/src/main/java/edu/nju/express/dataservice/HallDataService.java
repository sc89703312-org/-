package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.HallTransferReceiptPO;

public interface HallDataService extends Remote{
	public void addHall(HallPo po) throws RemoteException;
	public void removeHall(String id) throws RemoteException;
	public ArrayList<HallPo> showHall() throws RemoteException;
	
	public void addHallArrival(ArrivalReceiptPO po);
	public void removeHallArrival(String id);
	public ArrivalReceiptPO findHallArrival(String id);
	public ArrayList<ArrivalReceiptPO> getAllHallArrival();
	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list);
	
	public void addHallTransfer(HallTransferReceiptPO po);
	public void removeHallTransfer(String id);
	public HallTransferReceiptPO findHallTransfer(String id);
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer();
	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list);
	
	public void addHallDeliver(DeliverReceiptPO po);
	public void removeHallDeliver(String id);
	public DeliverReceiptPO findHallDeliver(String id);
	public ArrayList<DeliverReceiptPO> getAllHallDeliver();
	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list);
}
