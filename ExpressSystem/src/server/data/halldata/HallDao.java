package server.data.halldata;

import java.util.ArrayList;

import client.po.HallPo.ArrivalReceiptPO;
import client.po.HallPo.DeliverReceiptPO;
import client.po.HallPo.TransferReceiptPO;
import client.vo.hallvo.HallVO;

public interface HallDao {
	public void addHall(String id,String location);
	public void removeHall(String id);
	public ArrayList<HallVO> showHall();
	
	public void addArrivalReceipt(ArrivalReceiptPO po);
	public ArrayList<ArrivalReceiptPO> getArrivalReceipt();
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list);
	
	public void addTransferReceipt(TransferReceiptPO po);
	public ArrayList<TransferReceiptPO> getTransferReceipt();
	public void approveTransferReceipt(ArrayList<TransferReceiptPO> list);
	
	public void addDeliverReceipt(DeliverReceiptPO po);
	public ArrayList<DeliverReceiptPO> getDeliverReceipt();
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list);
}
