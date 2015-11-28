package edu.nju.express.vo;

import java.util.ArrayList;



public class DeliverReceiptVO extends ReceiptVOBase{

	private String deliver;
	private ArrayList<OrderVO> list;
	
	public DeliverReceiptVO(String id,String date, String deliver, ArrayList<OrderVO> list){
		this.id="DeliverReceipt"+id;
		this.date=date;
		this.deliver=deliver;
		this.list = list;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void resetOrderDeliver(){
			for(OrderVO ordervo:list){
				ordervo.setDeliver(deliver);;
			}
	}
	
	public void addOrderItem(OrderVO vo){
		list.add(vo);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return list;
	}
	
}
