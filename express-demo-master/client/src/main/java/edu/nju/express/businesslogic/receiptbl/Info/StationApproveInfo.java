package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public interface StationApproveInfo {

	public ArrayList<ArriveReceiptVO> viewAllArriveReceiptSubmitted();
	
	public void approveArriveReceipt(String id);
	
	public ArrayList<TransferReceiptVO> viewAllTransferReceiptSubmitted();
	
	public void approveTransferReceipt(String id);
}
