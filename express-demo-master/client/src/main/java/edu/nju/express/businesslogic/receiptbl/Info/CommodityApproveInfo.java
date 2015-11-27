package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

public interface CommodityApproveInfo {

	
	public ArrayList<EnterReceiptVO> viewAllEnterReceiptSubmitted();
	
	public ResultMessage approveEnterReceipt(String id);
	
	public ArrayList<EnterReceiptVO> viewAllEnterReceipt();
	
	public ArrayList<ExitReceiptVO> viewAllExitReceiptSubmitted();
	
	public ResultMessage approveExitReceipt(String id);
	
	public ArrayList<ExitReceiptVO> viewAllExitReceipt();
}
