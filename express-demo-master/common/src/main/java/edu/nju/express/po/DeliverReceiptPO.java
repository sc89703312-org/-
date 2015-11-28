package edu.nju.express.po;

import java.util.ArrayList;

import edu.nju.express.common.ReceiptState;



public class DeliverReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	private ArrayList<OrderPO> list;
	
	public DeliverReceiptPO(String id,String date, String deliver, ReceiptState state){
		this.id="DeliverReceipt"+id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void addOrderItem(OrderPO po){
		list.add(po);
	}
	
	
}
