package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public interface StationInfo {
	
	public ArrayList<ArriveReceiptVO> viewApproveArrive();
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer();
	
	public OrderVO po_to_vo_order(OrderPO po);
	
	public OrderPO vo_to_po_order(OrderVO vo);

}
