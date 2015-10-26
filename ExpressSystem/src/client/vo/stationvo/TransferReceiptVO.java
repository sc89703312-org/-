package client.vo.stationvo;

import java.util.ArrayList;

import client.vo.ordervo.OrderVO;

public class TransferReceiptVO {

	String id;
	String date;
	String to;
	String location;
	
	ArrayList<OrderVO> orderList;
	
public TransferReceiptVO(String id, String date, String to, ArrayList<OrderVO> list){
		
		this.id = id;
		this. date = date;
		this.to = to;
		
	}
	
}
