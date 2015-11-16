package client.businesslogic.stationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.stationBlService.StationReceiptBlService;
import client.dataservice.stationdataservice.StationDataService;
import client.main.RMIHelper;
import client.po.orderpo.OrderPO;
import client.po.stationpo.ArriveReceiptPO;
import client.po.stationpo.TransferReceiptPO;
import client.vo.ordervo.OrderVO;
import client.vo.stationvo.ArriveReceiptVO;
import client.vo.stationvo.TransferReceiptVO;

public class StationReceiptBl implements StationReceiptBlService{
	
	StationDataService stationDataService;
	
	public StationReceiptBl(){
		//stationDataService = RMIHelper.getStationDataService();
	}

	@Override
	public ResultMessage creatArriveReceipt(ArrayList<OrderVO> list, String id,
			String date, String from, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage creatTransferReceipt(ArrayList<OrderVO> list,
			String id, String date, String to, String location) {
		// TODO Auto-generated method stub
		return null;
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
	
	
	public OrderVO po_to_vo_order(OrderPO po){
		
		client.vo.ordervo.Etype typevo = null;
		client.po.orderpo.Etype typepo = po.getType();
		
        if(typepo==client.po.orderpo.Etype.ECONOMICAL)
        	typevo = client.vo.ordervo.Etype.ECONOMICAL;
        else
        	if(typepo==client.po.orderpo.Etype.FAST)
            	typevo = client.vo.ordervo.Etype.FAST;
        	else
        		if(typepo==client.po.orderpo.Etype.STANDARD)
                	typevo = client.vo.ordervo.Etype.STANDARD;
		
		OrderVO vo = new OrderVO(po.getSenderName(),po.getSenderAddress(),po.getSenderPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getReceiverName(),po.getReceiverAddress(),po.getReceiverPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getNum(),po.getWeight(),po.getVolume(),po.getGoodsName(),po.getSize(),
				po.getPkgCost(),po.getTotalCost(),po.getID(),typevo,po.getState(),po.getExpectedTime(),
				po.getCurrentSpot());
		
		return vo;
		
	}
	
	
}
