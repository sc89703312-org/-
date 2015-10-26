package client.blservice.stationBlService;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.ordervo.OrderVO;

public interface StationBlService {

	public ResultMessage creatArriveReceipt(ArrayList<OrderVO> list, String id, String date, String from, String location);
	public ResultMessage creatTransferReceipt(ArrayList<OrderVO> list, String id, String date, String to, String location);
	
}
