package edu.nju.express.po;

import java.util.ArrayList;



public class DeliverReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**派件员*/
	private String deliver;
	/**快件当前位置信息*/
	private String location;
	/**派件员需要派送的所有订单*/
	private ArrayList<OrderPO> list;
	
	public DeliverReceiptPO(String id,String date, String location, String deliver, ArrayList<OrderPO> list){
		this.id="DeliverReceipt"+id;
		this.date=date;
		this.location = location;
		this.deliver=deliver;
		this.list = list;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void addOrderItem(OrderPO po){
		list.add(po);
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return list;
	}
	
}
