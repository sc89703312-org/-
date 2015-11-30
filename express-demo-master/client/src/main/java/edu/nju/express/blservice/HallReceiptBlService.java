package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;

public interface HallReceiptBlService {

		public ArrivalReceiptVO createArrivalReceipt(String id);
		
		public void subArrivalReceipt(ArrivalReceiptVO vo);
		
		public ArrayList<OrderVO> showCurrentOrder();
		
		public void subHallTransferReceipt(String transportID, String to, String carID, String supervisor, String guard, ArrayList<OrderVO> orderlist);
		
        public void subDeliverReceipt(String deliver, ArrayList<OrderVO> orderlist);
		
	}
