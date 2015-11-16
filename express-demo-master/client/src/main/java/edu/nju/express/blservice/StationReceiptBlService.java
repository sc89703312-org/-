package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.OrderVO;



public interface StationReceiptBlService {

	public ResultMessage creatArriveReceipt(ArrayList<String> list, String id, String date, String from, String location);
	public ResultMessage creatTransferReceipt(ArrayList<String> list, String id, String date, String to, String location);
	
}
