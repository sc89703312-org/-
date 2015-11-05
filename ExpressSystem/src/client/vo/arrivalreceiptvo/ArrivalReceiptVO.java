package client.vo.arrivalreceiptvo;

import java.util.List;

import client.po.GoodsState;
import client.po.ReceiptState;
import client.vo.ReceiptVOBase;
import client.vo.ordervo.OrderVO;

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
	private List<OrderVO> list;
	
	public ArrivalReceiptVO(String id, String date, String from, GoodsState gstate,ReceiptState state){
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
	
	public void addOrderItem(OrderVO vo){
		list.add(vo);
	}

}
