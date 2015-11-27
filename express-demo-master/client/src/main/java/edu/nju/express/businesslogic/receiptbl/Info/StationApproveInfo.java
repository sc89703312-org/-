package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public interface StationApproveInfo {

	public ArrayList<ArriveReceiptVO> viewAllArriveReceiptSubmitted();
	
	public ResultMessage approveArriveReceipt(String id);
	
	public ArrayList<ArriveReceiptVO> viewAllArriveReceipt();
	
	public ArrayList<TransferReceiptVO> viewAllTransferReceiptSubmitted();
	
	public ResultMessage approveTransferReceipt(String id);
	
	public ArrayList<TransferReceiptVO> viewAllTransferReceipt();
}
