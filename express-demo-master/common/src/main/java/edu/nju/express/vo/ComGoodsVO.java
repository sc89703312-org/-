package edu.nju.express.vo;



public class ComGoodsVO {

	OrderVO order;
	String comLocation;
	
	public ComGoodsVO(OrderVO order, String comLocation){
		
		this.order = order;
		this.comLocation = comLocation;
		
	}
	
	public OrderVO getOrder(){
		return order;
	}
	
	public String getComLocation(){
		return comLocation;
	}
	
}
