package edu.nju.express.vo;

import java.util.ArrayList;

import edu.nju.express.common.*;



public class ArrivalReceiptVO extends ReceiptVOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String from;
	private GoodsState goodsState;
	private ArrayList<OrderVO> list;
	
	public ArrivalReceiptVO(String id, String date, String from, GoodsState gstate, ArrayList<OrderVO> voList){
		this.id="ArrivalReceipt"+id;
		this.date=date;
		this.from=from;
		this.goodsState=gstate;
		this.list = voList;
	}	
	
	public String getFrom(){
		return from;
	}
	
	public GoodsState getGoodsState(){
		return goodsState;
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return this.list;
	}

}
