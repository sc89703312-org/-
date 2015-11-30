package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public interface StationInfo {
	
	public ArrayList<ArriveReceiptVO> viewApproveArrive(String comID);
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer(String comID);

}
