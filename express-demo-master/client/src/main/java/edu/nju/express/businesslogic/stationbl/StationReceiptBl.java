package edu.nju.express.businesslogic.stationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.express.blservice.StationReceiptBlService;
import edu.nju.express.businesslogic.commoditybl.StationInfo;
import edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo;
import edu.nju.express.businesslogic.stationbl.Info.OrderInfo;
import edu.nju.express.common.Convert;
import edu.nju.express.common.Etype;
import edu.nju.express.common.MyDate;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.SetOrderSpot;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.init.client;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.TransferReceiptPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;



public class StationReceiptBl implements StationReceiptBlService, StationInfo, StationApproveInfo{
	
	StationDataService stationDataService;
	HallDataService hallDataService;
	OrderInfo orderInfo;
	SetOrderSpot setOrderSpot;
	
	String stationID;
	String location;
	
	public StationReceiptBl(OrderInfo orderInfo, SetOrderSpot setOrderSpot){
		stationDataService = RMIHelper.getStationDataService();
		hallDataService = RMIHelper.getHallDataService();
		this.orderInfo= orderInfo;
		this.setOrderSpot = setOrderSpot;
	}
	
	
	@Override
	public ArriveReceiptVO creatArriveReceipt(String id) {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		try {
			this.location = stationDataService.getLocation(stationID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id.contains("HallTransferReceipt")){
            try {
				HallTransferReceiptVO transfervo = Convert.po_to_vo_halltransfer(hallDataService.findHallTransfer(id));
				if(transfervo.getDestination().equals(location)){
				    ArriveReceiptVO vo = new ArriveReceiptVO(stationDataService.nextArriveID(stationID),MyDate.getCurrentDate(),transfervo.getLocation(),location,transfervo.getOrderlist());
				    return vo;
				}
				else
					return null;
			    } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			    }
			}
		else if(id.contains("TransferReceipt")){
			try {
				TransferReceiptVO transfervo = Convert.po_to_vo_transfer(stationDataService.getTransfer(id));
				if(transfervo.getTo().equals(location)){
					ArriveReceiptVO vo = new ArriveReceiptVO(stationDataService.nextArriveID(stationID),MyDate.getCurrentDate(),transfervo.getLocation(),location,transfervo.getList());
					return vo;
				}
				else
					return null;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
		
	}

	@Override
	public void subArriveReceipt(ArriveReceiptVO vo) {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		try {
			this.location = stationDataService.getLocation(stationID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArriveReceiptPO po = Convert.vo_to_po_arrive(vo);
		ArrayList<OrderPO> orderlist = po.getOrderList();
		for(int i=0;i<orderlist.size();i++)
			setOrderSpot.modifySpot(orderlist.get(i).getID(), location);
		try {
			stationDataService.addArriveReceipt(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<OrderVO> showCurrentOrder() {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		try {
			ArrayList<ArriveReceiptPO> arrivelist = stationDataService.getArriveReceipt(stationID);
			ArrayList<TransferReceiptPO> transferlist = stationDataService.getTransferReceipt(stationID);
			ArrayList<OrderPO> polist = new ArrayList<OrderPO>();
			for(int i=0;i<arrivelist.size();i++)
				polist.addAll(arrivelist.get(i).getOrderList());
			for(int i=0;i<transferlist.size();i++)
				polist.addAll(transferlist.get(i).getOrderList());
			for(int i=0;i<polist.size();i++){
				for(int j=i+1;j<polist.size();j++){
					OrderPO po = polist.get(j);
					if(polist.get(i).getID().equals(po.getID())){
						polist.remove(po);
						j--;
					}
				}
			}
			
			ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
			for(int i=0;i<polist.size();i++)
				orderlist.add(Convert.po_to_vo_order(polist.get(i)));
			
			return orderlist;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void subTransferReceipt(ArrayList<OrderVO> orderlist,
			String to, String transportID, String supervisor, Etype etype) {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		try {
			this.location = stationDataService.getLocation(stationID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TransferReceiptVO vo = new TransferReceiptVO(stationDataService.nextTransferID(stationID),MyDate.getCurrentDate(),to,location,transportID,supervisor,etype,orderlist);
			stationDataService.addTransferReceipt(Convert.vo_to_po_transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

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
				OrderVO ordervo = Convert.po_to_vo_order(orderpo);
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
			
		    TransferReceiptVO vo = Convert.po_to_vo_transfer(poList.get(i));
			voList.add(vo);
			
		}
		
		return voList;
		
	}
	
	
	@Override
	public ArrayList<ArriveReceiptVO> viewAllArriveReceiptSubmitted() {
		// TODO Auto-generated method stub
		
		ArrayList<ArriveReceiptVO> voList = new ArrayList<ArriveReceiptVO>();
		ArrayList<ArriveReceiptPO> poList = new ArrayList<ArriveReceiptPO>();
		
		try {
			poList = stationDataService.getSummitArrive();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){
			
			ArrayList<OrderPO> orderpolist= poList.get(i).getOrderList();
			ArrayList<OrderVO> ordervolist= new ArrayList<OrderVO>();
			
			for(int j=0;j<orderpolist.size();j++){
				
				OrderPO orderpo = orderpolist.get(j);
				OrderVO ordervo = Convert.po_to_vo_order(orderpo);
				ordervolist.add(ordervo);
				
			}
			
			ArriveReceiptVO vo = new ArriveReceiptVO(poList.get(i).getID(),poList.get(i).getDate(),
					poList.get(i).getFrom(),poList.get(i).getLocation(),ordervolist);
			
			voList.add(vo);
			
		}
		
		return voList;
		
	}

	@Override
	public ArrayList<TransferReceiptVO> viewAllTransferReceiptSubmitted() {
		// TODO Auto-generated method stub
		
		ArrayList<TransferReceiptVO> voList = new ArrayList<TransferReceiptVO>();
		ArrayList<TransferReceiptPO> poList = new ArrayList<TransferReceiptPO>();
		
		try {
			poList = stationDataService.getSummitTransfer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<poList.size();i++){

			TransferReceiptVO vo = Convert.po_to_vo_transfer(poList.get(i));
			voList.add(vo);
			
		}
		
		return voList;
		
	}

	@Override
	public ArrayList<ArriveReceiptVO> viewAllArriveReceipt() {
		// TODO Auto-generated method stub
		ArrayList<ArriveReceiptVO> volist = new ArrayList<ArriveReceiptVO>();
		ArrayList<ArriveReceiptPO> polist = null;
		try {
			polist = stationDataService.getArriveReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_arrive(polist.get(i)));
		return volist;
	}

	@Override
	public ArrayList<TransferReceiptVO> viewAllTransferReceipt() {
		// TODO Auto-generated method stub
		ArrayList<TransferReceiptVO> volist = new ArrayList<TransferReceiptVO>();
		ArrayList<TransferReceiptPO> polist = null;
		try {
			polist = stationDataService.getTransferReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_transfer(polist.get(i)));
		return volist;
	}


	@Override
	public ArrayList<ArriveReceiptVO> viewApproveArrive(String comID) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<ArriveReceiptPO> polist = stationDataService.getApproveArrive(comID);
			ArrayList<ArriveReceiptVO> volist = new ArrayList<ArriveReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_arrive(polist.get(i)));
            return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public ArrayList<TransferReceiptVO> viewApproveTransfer(String comID) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<TransferReceiptPO> polist = stationDataService.getApproveTransfer(comID);
			ArrayList<TransferReceiptVO> volist = new ArrayList<TransferReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_transfer(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}


	@Override
	public void handleArrive(String id) {
		// TODO Auto-generated method stub
		try {
			stationDataService.handleArrive(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void handleTransfer(String id) {
		// TODO Auto-generated method stub
		try {
			stationDataService.handleTransfer(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
