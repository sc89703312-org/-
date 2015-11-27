package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

public interface CommodityApproveInfo {

	
	public ArrayList<EnterReceiptVO> viewAllEnterReceiptSubmitted();
	
	public void approveEnterReceipt(String id);
	
	public ArrayList<ExitReceiptVO> viewAllExitReceiptSubmitted();
	
	public void approveExitReceipt(String id);
}
