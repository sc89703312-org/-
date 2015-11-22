package edu.nju.express.po;

import java.util.ArrayList;

import edu.nju.express.common.GoodsState;
import edu.nju.express.common.ReceiptState;



public class ArrivalReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743990485972024749L;

	private String from;
	private GoodsState goodsState;
	private ArrayList<OrderPO> orderList;
	
	public ArrivalReceiptPO(String id, String date, String from, GoodsState gstate,ReceiptState state){
		this.id=id;
		this.date=date;
		this.from=from;
		this.goodsState=gstate;
		this.state=state;
	}

	
	
	public String getFrom(){
		return from;
	}
	
	public GoodsState getGoodsState(){
		return goodsState;
	}
	
	public void addOrderItem(OrderPO po){
		orderList.add(po);
	}

}
