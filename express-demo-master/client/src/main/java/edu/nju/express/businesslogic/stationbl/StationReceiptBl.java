package edu.nju.express.businesslogic.stationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.StationReceiptBlService;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.init.client;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.TransferReceiptPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;



public class StationReceiptBl implements StationReceiptBlService{
	
	StationDataService stationDataService;
	OrderBL orderBl;
	
	public StationReceiptBl(OrderBL orderBl){
		//stationDataService = RMIHelper.getStationDataService();
		this.orderBl = orderBl;
	}

	@Override
	public ResultMessage creatArriveReceipt(ArrayList<String> list, String id,
			String date, String from, String location) {
		// TODO Auto-generated method stub
		
		ResultMessage result = ResultMessage.VALID;
		
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		for(int i=0;i<list.size();i++){
			if(list.get(i)==null){
				result = ResultMessage.INVALID;
				return result;
			}
			OrderPO po = vo_to_po_order(orderBl.view(list.get(i)));
			orderList.add(po);
		}
		
		ArriveReceiptPO po = new ArriveReceiptPO(id,date,from,location,orderList);
		
		/*
		try {
			stationDataService.addArriveReceipt(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		return result;
	}

	@Override
	public ResultMessage creatTransferReceipt(ArrayList<String> list,
			String id, String date, String to, String location) {
		// TODO Auto-generated method stub
		
		ResultMessage result = ResultMessage.VALID;
		
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		for(int i=0;i<list.size();i++){
			if(list.get(i)==null){
				result = ResultMessage.INVALID;
				return result;
			}
			OrderPO po = vo_to_po_order(orderBl.view(list.get(i)));
			orderList.add(po);
		}
		
		TransferReceiptPO po = new TransferReceiptPO(id,date,to,location,orderList);
		/*
		try {
			stationDataService.addTransferReceipt(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		return result;
	}

	public ResultMessage approveArriveReceipt(String id){
		
		ResultMessage result = null;
		
		try {
			result = stationDataService.approveArriveReceipt(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ResultMessage approveTransferReceipt(String id){
        
		ResultMessage result = null;
		
		try {
			result = stationDataService.approveTransferReceipt(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ArrayList<ArriveReceiptVO> viewAllArrive(){
		
		ArrayList<ArriveReceiptVO> voList = new ArrayList<ArriveReceiptVO>();
		ArrayList<ArriveReceiptPO> poList = new ArrayList<ArriveReceiptPO>();
		
		try {
			poList = stationDataService.getArriveReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){
			
			ArrayList<OrderPO> orderpolist= poList.get(i).getOrderList();
			ArrayList<OrderVO> ordervolist= new ArrayList<OrderVO>();
			
			for(int j=0;j<orderpolist.size();j++){
				
				OrderPO orderpo = orderpolist.get(j);
				OrderVO ordervo = po_to_vo_order(orderpo);
				ordervolist.add(ordervo);
				
			}
			
			ArriveReceiptVO vo = new ArriveReceiptVO(poList.get(i).getID(),poList.get(i).getDate(),
					poList.get(i).getFrom(),poList.get(i).getLocation(),ordervolist);
			
			voList.add(vo);
			
		}
		
		return voList;
		
	}
	
	
	public ArrayList<TransferReceiptVO> viewAllTransfer(){
		
		ArrayList<TransferReceiptVO> voList = new ArrayList<TransferReceiptVO>();
		ArrayList<TransferReceiptPO> poList = new ArrayList<TransferReceiptPO>();
		
		try {
			poList = stationDataService.getTransferReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){
			
			ArrayList<OrderPO> orderpolist= poList.get(i).getOrderList();
			ArrayList<OrderVO> ordervolist= new ArrayList<OrderVO>();
			
			for(int j=0;j<orderpolist.size();j++){
				
				OrderPO orderpo = orderpolist.get(j);
				OrderVO ordervo = po_to_vo_order(orderpo);
				ordervolist.add(ordervo);
				
			}
			
			TransferReceiptVO vo = new TransferReceiptVO(poList.get(i).getID(),poList.get(i).getDate(),
					poList.get(i).getTo(),poList.get(i).getLocation(),ordervolist);
			
			voList.add(vo);
			
		}
		
		return voList;
		
	}
	
	
	public ArrayList<ArriveReceiptVO> viewApproveArrive(){
		
		ArrayList<ArriveReceiptVO> voList = new ArrayList<ArriveReceiptVO>();
		ArrayList<ArriveReceiptPO> poList = new ArrayList<ArriveReceiptPO>();
		
		try {
			poList = stationDataService.getArriveReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){
			
			ArrayList<OrderPO> orderpolist= poList.get(i).getOrderList();
			ArrayList<OrderVO> ordervolist= new ArrayList<OrderVO>();
			
			for(int j=0;j<orderpolist.size();j++){
				
				OrderPO orderpo = orderpolist.get(j);
				OrderVO ordervo = po_to_vo_order(orderpo);
				ordervolist.add(ordervo);
				
			}
			
			ArriveReceiptVO vo = new ArriveReceiptVO(poList.get(i).getID(),poList.get(i).getDate(),
					poList.get(i).getFrom(),poList.get(i).getLocation(),ordervolist);
			
			voList.add(vo);
			
		}
		
		return voList;
		
	}
	
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer(){
		
		ArrayList<TransferReceiptVO> voList = new ArrayList<TransferReceiptVO>();
		ArrayList<TransferReceiptPO> poList = new ArrayList<TransferReceiptPO>();
		
		try {
			poList = stationDataService.getTransferReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){
			
			ArrayList<OrderPO> orderpolist= poList.get(i).getOrderList();
			ArrayList<OrderVO> ordervolist= new ArrayList<OrderVO>();
			
			for(int j=0;j<orderpolist.size();j++){
				
				OrderPO orderpo = orderpolist.get(j);
				OrderVO ordervo = po_to_vo_order(orderpo);
				ordervolist.add(ordervo);
				
			}
			
			TransferReceiptVO vo = new TransferReceiptVO(poList.get(i).getID(),poList.get(i).getDate(),
					poList.get(i).getTo(),poList.get(i).getLocation(),ordervolist);
			
			voList.add(vo);
			
		}
		
		return voList;
		
	}
	
	
	private OrderVO po_to_vo_order(OrderPO po){
		
		OrderVO vo = new OrderVO(po.getSenderName(),po.getSenderAddress(),po.getSenderPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getReceiverName(),po.getReceiverAddress(),po.getReceiverPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getNum(),po.getWeight(),po.getVolume(),po.getGoodsName(),po.getSize(),
				po.getPkgCost(),po.getTotalCost(),po.getID(),po.getType(),po.getState(),po.getExpectedTime(),
				po.getCurrentSpot());
		
		return vo;
		
	}
	
	
	private OrderPO vo_to_po_order(OrderVO vo){
		
		OrderPO po = new OrderPO(vo.getSenderName(),vo.getSenderAddress(),vo.getSenderPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getReceiverName(),vo.getReceiverAddress(),vo.getReceiverPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getNum(),vo.getWeight(),vo.getVolume(),vo.getGoodsName(),vo.getSize(),
				vo.getPkgCost(),vo.getTotalCost(),vo.getID(),vo.getType(),vo.getState(),vo.getExpectedTime(),
				vo.getCurrentSpot());
		
		return po;
		
	}
	
	
}
