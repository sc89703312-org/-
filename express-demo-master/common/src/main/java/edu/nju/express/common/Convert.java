package edu.nju.express.common;

import java.util.ArrayList;

import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.Balancepo;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.Driverpo;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;
import edu.nju.express.po.HallTransferReceiptPO;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.po.TransferReceiptPO;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Carvo;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.Drivervo;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.Paymentvo;
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
	
	public static ArrayList<OrderVO> po_to_vo_orderlist(ArrayList<OrderPO> polist){
		
		ArrayList<OrderVO> volist = new ArrayList<OrderVO>();
		for(int i=0;i<polist.size();i++)
			volist.add(po_to_vo_order(polist.get(i)));
		
		return volist;
		
	}
	
	public static ArrayList<OrderPO> vo_to_po_orderlist(ArrayList<OrderVO> volist){
		
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
	
	public static TransferReceiptVO po_to_vo_transfer(TransferReceiptPO po){
		
		TransferReceiptVO vo = new TransferReceiptVO(po.getID(),po.getDate(),po.getTo(),po.getLocation(),po_to_vo_orderlist(po.getOrderList()));
		
		return vo;
		
	}
	
	public static TransferReceiptPO vo_to_po_transfer(TransferReceiptVO vo){
		
		TransferReceiptPO po = new TransferReceiptPO(vo.getID(),vo.getDate(),vo.getTo(),vo.getLocation(),vo_to_po_orderlist(vo.getList()));
		
		return po;
		
	}
	
	public static EnterReceiptVO po_to_vo_enter(EnterReceiptPO po){
		
		ArrayList<ComGoodsPO> goodspo = po.getGoods();
		ArrayList<ComGoodsVO> goodsvo = new ArrayList<ComGoodsVO>();
		for(int i=0;i<goodspo.size();i++)
			goodsvo.add(new ComGoodsVO(po_to_vo_order(goodspo.get(i).getOrder()),
					goodspo.get(i).getType(),goodspo.get(i).getLine(),goodspo.get(i).getShelf(),
					goodspo.get(i).getCell()));
			
		EnterReceiptVO vo = new EnterReceiptVO(goodsvo,po.getID(),po.getDate(),po.getLocation());
		
		return vo;
		
	}
	
    public static EnterReceiptPO vo_to_po_enter(EnterReceiptVO vo){
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(vo_to_po_order(goodsvo.get(i).getOrder()),
					goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),
					goodsvo.get(i).getCell()));
			
		EnterReceiptPO po = new EnterReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		
		return po;
		
	}
	
    public static ExitReceiptVO po_to_vo_exit(ExitReceiptPO po){
		
		ArrayList<ComGoodsPO> goodspo = po.getGoods();
		ArrayList<ComGoodsVO> goodsvo = new ArrayList<ComGoodsVO>();
		for(int i=0;i<goodspo.size();i++)
			goodsvo.add(new ComGoodsVO(po_to_vo_order(goodspo.get(i).getOrder()),
					goodspo.get(i).getType(),goodspo.get(i).getLine(),goodspo.get(i).getShelf(),
					goodspo.get(i).getCell()));
			
		ExitReceiptVO vo = new ExitReceiptVO(goodsvo,po.getID(),po.getDate(),po.getLocation());
		
		return vo;
		
	}
    
    public static ExitReceiptPO vo_to_po_exit(ExitReceiptVO vo){
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(vo_to_po_order(goodsvo.get(i).getOrder()),
					goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),
					goodsvo.get(i).getCell()));
			
		ExitReceiptPO po = new ExitReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		
		return po;
		
	}
    
    public static ArrivalReceiptVO po_to_vo_arrival(ArrivalReceiptPO po){
    	
    	ArrivalReceiptVO vo = new ArrivalReceiptVO(po.getId(),po.getDate(),po.getFrom(),
    			po.getGoodsState(),po_to_vo_orderlist(po.getOrderList()));
    	
    	return vo;
    	
    }
    
    public static ArrivalReceiptPO vo_to_po_arrival(ArrivalReceiptVO vo){
    	
    	ArrivalReceiptPO po = new ArrivalReceiptPO(vo.getId(),vo.getDate(),vo.getFrom(),
    			vo.getGoodsState(),vo_to_po_orderlist(vo.getOrderList()));
    	
    	return po;
    	
    }
    
    public static HallTransferReceiptVO po_to_vo_halltransfer(HallTransferReceiptPO po){
    	
    	HallTransferReceiptVO vo = new HallTransferReceiptVO(po.getDate(),po.getHallID(),
    			po.getTransportID(),po.getDestination(),po.getCarID(),po.getSupervisor(),
    			po.getGuard(),po_to_vo_orderlist(po.getOrderlist()));
    	
    	return vo;
    	
    }
    
    public static HallTransferReceiptPO vo_to_po_halltransfer(HallTransferReceiptVO vo){
    	
    	HallTransferReceiptPO po = new HallTransferReceiptPO(vo.getDate(),vo.getHallID(),
    			vo.getTransportID(),vo.getDestination(),vo.getCarID(),vo.getSupervisor(),
    			vo.getGuard(),vo_to_po_orderlist(vo.getOrderlist()));
    	
    	return po;
    	
    }
    
    public static DeliverReceiptVO po_to_vo_deliver(DeliverReceiptPO po){
    	
    	DeliverReceiptVO vo = new DeliverReceiptVO(po.getId(),po.getDate(),
    			po.getDeliver(),po_to_vo_orderlist(po.getOrderList()));
    	
    	return vo;
    	
    }
    
    public static DeliverReceiptPO vo_to_po_deliver(DeliverReceiptVO vo){
    	
    	DeliverReceiptPO po = new DeliverReceiptPO(vo.getId(),vo.getDate(),
    			vo.getDeliver(),vo_to_po_orderlist(vo.getOrderList()));
    	
    	return po;
    	
    }
    
    
    
    
	public static Balancepo vo_to_po_Balance(Balancevo vo){
		return new Balancepo(vo.getDate(), vo.getMoney(), 
				                      vo.getName(), vo.getBanking(),
				                      vo.getItem(), vo.getRemark());
	}
	
	
	
	public static Balancevo po_to_vo_Balance(Balancepo po){
		return new Balancevo(po.getDate(), po.getMoney(), 
				                      po.getName(), po.getBanking(),
				                      po.getItem(), po.getRemark());
	}

	
	
	public static Paymentpo vo_to_po_Payment(Paymentvo vo){
		
		return new Paymentpo(vo.getDate(), vo.getPay(),
				                        vo.getCourier_id(), vo.getOrder_id(),
				                        vo.getBankaccount());
		
	}
	
	
	public static Paymentvo po_to_vo_Payment(Paymentpo po){
		
		return new Paymentvo(po.getDate(), po.getPay(),
				                        po.getCourier_id(), po.getOrder_id(),
				                        po.getBankaccount());
		
	}
	
	public static Carpo vo_to_po_Car(Carvo vo){
		return new Carpo(vo.getId(), vo.getMotor(),
				                 vo.getCar(), vo.getBase(),
				                 vo.getPurchase(), vo.getUse());
	}
	
	
	public static Carvo po_to_vo_Car(Carpo po){
		return new Carvo(po.getId(), po.getMotor(),
				                 po.getCar(), po.getBase(),
				                 po.getPurchase() ,po.getUse());
	}
	
	public static Driverpo vo_to_po_Driver(Drivervo vo){
		return new Driverpo(vo.getId(), vo.getName(),
				                     vo.getBirthDate(), vo.getCertificate(),
				                     vo.getPhone(), vo.getHallId(),
				                     vo.getSex(), vo.getDdl());
	}
	
	
	public static Drivervo po_to_vo_Driver(Driverpo po){
		return new Drivervo(po.getId(), po.getName(),
				                 po.getBirthDate(), po.getCertificate(),
				                 po.getPhone() ,po.getHallId(),
				                 po.getSex(),po.getDdl());
	}
}
