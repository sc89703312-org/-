package client.po.commoditypo;

import client.po.orderpo.OrderPO;

public class ComGoodsPO {

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
