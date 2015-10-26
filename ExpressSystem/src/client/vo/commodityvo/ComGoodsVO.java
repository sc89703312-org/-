package client.vo.commodityvo;

import client.vo.ordervo.OrderVO;

public class ComGoodsVO {

	OrderVO order;
	String comLocation;
	
	public ComGoodsVO(OrderVO order, String comLocation){
		
		this.order = order;
		this.comLocation = comLocation;
		
	}
	
}
