package client.po.commoditypo;

import java.io.Serializable;

import client.po.orderpo.OrderPO;

public class ComGoodsPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	OrderPO order;
	String comLocation;
	
	public ComGoodsPO(OrderPO order, String comLocation){
		this.order = order;
		this.comLocation = comLocation;
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
