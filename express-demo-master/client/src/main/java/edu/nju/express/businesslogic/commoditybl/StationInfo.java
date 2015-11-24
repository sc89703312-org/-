package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public interface StationInfo {
	
	public ArrayList<ArriveReceiptVO> viewApproveArrive();
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer();

}
