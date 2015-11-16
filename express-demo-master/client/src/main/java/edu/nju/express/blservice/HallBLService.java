package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.*;


public interface HallBLService {

	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo);
	
	public ResultMessage createTransferReceipt(TransferReceiptVO vo);
	
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo);
	
	
	
}
