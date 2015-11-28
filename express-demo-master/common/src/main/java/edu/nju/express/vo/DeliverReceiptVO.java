package edu.nju.express.vo;

import java.util.ArrayList;

import edu.nju.express.common.ReceiptState;



public class DeliverReceiptVO extends ReceiptVOBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	private ArrayList<OrderVO> list;
	
	public DeliverReceiptVO(String id,String date, String deliver, ReceiptState state){
		this.id="DeliverReceipt"+id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
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
}
