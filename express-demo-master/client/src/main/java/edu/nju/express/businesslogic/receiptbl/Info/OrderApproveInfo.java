package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.OrderVO;

public interface OrderApproveInfo {

	
	
	public ArrayList<OrderVO> viewAllOrderSubmitted();
	
	public void approveOrder(String id);
}
