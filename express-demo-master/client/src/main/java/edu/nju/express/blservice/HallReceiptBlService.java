package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;

public interface HallReceiptBlService {

		public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo);
		
		public ResultMessage createTransferReceipt(HallTransferReceiptVO vo);
		
		public ResultMessage createDeliverReceipt(DeliverReceiptVO vo);
		
		
		
	}
