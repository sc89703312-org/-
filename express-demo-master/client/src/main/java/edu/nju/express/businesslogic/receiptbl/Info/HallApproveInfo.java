package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;

public interface HallApproveInfo {

	
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceiptSubmitted();
	
	public void approveArrivalReceipt(String id);
	
    public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceiptSubmitted();
	
	public void approveHallTransferReceipt(String id);
	
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceiptSubmitted();
	
	public void approveDeliverReceipt(String id);
	
}
