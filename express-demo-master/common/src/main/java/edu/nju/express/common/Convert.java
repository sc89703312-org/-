package edu.nju.express.common;

import java.util.ArrayList;

import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.TransferReceiptPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public class Convert {
	
	public static OrderVO po_to_vo_order(OrderPO po){
		
		OrderVO vo = new OrderVO(po.getSenderName(),po.getSenderAddress(),po.getSenderPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getReceiverName(),po.getReceiverAddress(),po.getReceiverPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getNum(),po.getWeight(),po.getVolume(),po.getGoodsName(),po.getSize(),
				po.getPkgCost(),po.getTotalCost(),po.getID(),po.getType(),po.getArrivalState(),po.getExpectedTime(),
				po.getCurrentSpot());
		
		return vo;
		
	}
	
	public static OrderPO vo_to_po_order(OrderVO vo){
			
		OrderPO po = new OrderPO(vo.getSenderName(),vo.getSenderAddress(),vo.getSenderPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getReceiverName(),vo.getReceiverAddress(),vo.getReceiverPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getNum(),vo.getWeight(),vo.getVolume(),vo.getGoodsName(),vo.getSize(),
				vo.getPkgCost(),vo.getTotalCost(),vo.getID(),vo.getType(),vo.getState(),vo.getExpectedTime(),
				vo.getCurrentSpot());
			
		return po;
		
	}
	
	static ArrayList<OrderVO> po_to_vo_orderlist(ArrayList<OrderPO> polist){
		
		ArrayList<OrderVO> volist = new ArrayList<OrderVO>();
		for(int i=0;i<polist.size();i++)
			volist.add(po_to_vo_order(polist.get(i)));
		
		return volist;
		
	}
	
	static ArrayList<OrderPO> vo_to_po_orderlist(ArrayList<OrderVO> volist){
		
		ArrayList<OrderPO> polist = new ArrayList<OrderPO>();
		for(int i=0;i<volist.size();i++)
			polist.add(vo_to_po_order(volist.get(i)));
		
		return polist;
		
	}
	
	public static ArriveReceiptVO po_to_vo_arrive(ArriveReceiptPO po){
		
		ArriveReceiptVO vo = new ArriveReceiptVO(po.getID(),po.getDate(),po.getFrom(),po.getLocation(),po_to_vo_orderlist(po.getOrderList()));
		
		return vo;
		
	}
	
	public static ArriveReceiptPO vo_to_po_arrive(ArriveReceiptVO vo){
		
		ArriveReceiptPO po = new ArriveReceiptPO(vo.getID(),vo.getDate(),vo.getFrom(),vo.getLocation(),vo_to_po_orderlist(vo.getList()));
		
		return po;
		
	}
	
	public static TransferReceiptVO po_to_vo_arrive(TransferReceiptPO po){
		
		TransferReceiptVO vo = new TransferReceiptVO(po.getID(),po.getDate(),po.getTo(),po.getLocation(),po_to_vo_orderlist(po.getOrderList()));
		
		return vo;
		
	}
	
	public static TransferReceiptPO vo_to_po_arrive(TransferReceiptVO vo){
		
		TransferReceiptPO po = new TransferReceiptPO(vo.getID(),vo.getDate(),vo.getTo(),vo.getLocation(),vo_to_po_orderlist(vo.getList()));
		
		return po;
		
	}

}
