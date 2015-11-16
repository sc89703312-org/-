package client.blservice.stationBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.stationBlService.StationReceiptBlService;
import client.vo.ordervo.OrderVO;

public class StationBlService_Stub implements StationReceiptBlService{

	public ResultMessage creatArriveReceipt(ArrayList<OrderVO> list, String id, String date, String from, String location){
		
		ResultMessage result;
		if(location=="Nanjing")
			result = ResultMessage.VALID;
		else
			result = ResultMessage.INVALID;
		
		return result;
		
	}
	
	public ResultMessage creatTransferReceipt(ArrayList<OrderVO> list, String id, String date, String to, String location){
		
		ResultMessage result;
		if(location=="Nanjing")
			result = ResultMessage.VALID;
		else
			result = ResultMessage.INVALID;
		
		return result;
		
	}
	
}
