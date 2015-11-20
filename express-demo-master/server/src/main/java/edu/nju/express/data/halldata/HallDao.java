package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.po.*;



public interface HallDao {
	public void addHall(String id,String location);
	public void removeHall(String id);
	public ArrayList<HallPo> showHall();
	
	public void addArrivalReceipt(ArrivalReceiptPO po);
	public ArrayList<ArrivalReceiptPO> getArrivalReceipt();
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list);
	
	public void addTransferReceipt(HallTransferReceiptPO po);
	public ArrayList<HallTransferReceiptPO> getTransferReceipt();
	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list);
	
	public void addDeliverReceipt(DeliverReceiptPO po);
	public ArrayList<DeliverReceiptPO> getDeliverReceipt();
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list);
}
