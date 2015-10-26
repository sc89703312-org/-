package client.vo.stationvo;

import java.io.Serializable;
import java.util.ArrayList;

import client.vo.ordervo.OrderVO;

public class ArriveReceiptVO implements Serializable{

	String id;
	String date;
	String from;
	String location;
	
	ArrayList<OrderVO> orderList;
	
	public ArriveReceiptVO(String id, String date, String from, ArrayList<OrderVO> list){
		
		this.id = id;
		this. date = date;
		this.from = from;
		
	}
	
}
