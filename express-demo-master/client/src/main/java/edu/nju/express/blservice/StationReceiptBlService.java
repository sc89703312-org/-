package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.Etype;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;



public interface StationReceiptBlService {
	
	public ArriveReceiptVO creatArriveReceipt(String id);
	public void subArriveReceipt(ArriveReceiptVO vo);
	public ArrayList<OrderVO> showCurrentOrder();
	public void subTransferReceipt(ArrayList<OrderVO> orderlist, String to, String transportID, String supervisor, Etype etype);
	
}
