package edu.nju.express.po;

import java.io.Serializable;



public class ComGoodsPO extends PersistentObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	OrderPO order;
	String comLocation;
	
	public ComGoodsPO(OrderPO order, String comLocation){
		this.order = order;
		this.comLocation = comLocation;
		this.id = order.id;
		this.date = "";
	}
	
	public OrderPO getOrder(){
		return order;
	}
	
	public String getComLocation(){
		return comLocation;
	}
	
	public void modifyComLocation(String newComLocation){
		comLocation = newComLocation;
	}
}
