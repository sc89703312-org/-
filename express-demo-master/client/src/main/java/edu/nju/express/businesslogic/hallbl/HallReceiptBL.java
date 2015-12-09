package edu.nju.express.businesslogic.hallbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.businesslogic.hallbl.info.PaymentOrderInfo;
import edu.nju.express.businesslogic.receiptbl.Info.HallApproveInfo;
import edu.nju.express.businesslogic.stationbl.Info.OrderInfo;
import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.common.Convert;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.SetOrderSpot;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallTransferReceiptPO;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public class HallReceiptBL implements HallReceiptBlService, HallApproveInfo{
	
	String hallID;
	String location;
	
	PaymentOrderInfo paymentInfo;
	OrderInfo orderInfo;
	SetOrderSpot setOrderSpot;
	Vehiclebl vehiclebl;
	HallDataService hallDataService;
    StationDataService stationDataService;
	
	public HallReceiptBL(PaymentOrderInfo paymentInfo, OrderInfo orderInfo,Vehiclebl vehiclebl,SetOrderSpot setOrderSpot){
		this.orderInfo = orderInfo;
		this.vehiclebl = vehiclebl;
		this.setOrderSpot = setOrderSpot;
		this.paymentInfo = paymentInfo;
		hallDataService = RMIHelper.getHallDataService();	
		stationDataService = RMIHelper.getStationDataService();
	}

	@Override
	public ArrivalReceiptVO createArrivalReceipt(String id) {
		// TODO Auto-generated method stub
		
		hallID = LoginInfo.getUserID().substring(0, 5);
		
		try {
			location = hallDataService.getLocation(hallID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(id.contains("HallTransferReceipt")){
            try {
				HallTransferReceiptVO transfervo = Convert.po_to_vo_halltransfer(hallDataService.findHallTransfer(id));
				if(transfervo.getDestination().equals(location)){
				    ArrivalReceiptVO vo = new ArrivalReceiptVO(hallDataService.nextArrivalID(id),Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE,transfervo.getLocation(),location,transfervo.getOrderlist());
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
					ArrivalReceiptVO vo = new ArrivalReceiptVO(hallDataService.nextArrivalID(hallID),Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE,transfervo.getLocation(),location,transfervo.getList());
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
	public void subArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub
		
		hallID = LoginInfo.getUserID().substring(0, 5);
		
		try {
			location = hallDataService.getLocation(hallID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrivalReceiptPO po = Convert.vo_to_po_arrival(vo);
		ArrayList<OrderPO> orderlist = po.getOrderList();
		for(int i=0;i<orderlist.size();i++)
			setOrderSpot.modifySpot(orderlist.get(i).getID(), location);
		try {
			hallDataService.addHallArrival(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<OrderVO> showCurrentOrder() {
		// TODO Auto-generated method stub
		
		hallID = LoginInfo.getUserID().substring(0, 6);
		System.out.println(hallID);
		
		try {
			ArrayList<String> orderIDList = paymentInfo.getOrderListByHall(hallID);
			ArrayList<ArrivalReceiptPO> arrivalList = hallDataService.getAllHallArrival(hallID);
			for(int i=0;i<arrivalList.size();i++)
				for(int j=0;j<arrivalList.get(i).getOrderList().size();j++)
					orderIDList.add(arrivalList.get(i).getOrderList().get(j).getID());
			
			ArrayList<HallTransferReceiptPO> transferList = hallDataService.getAllHallTransfer(hallID);
			ArrayList<DeliverReceiptPO> deliverList = hallDataService.getAllHallDeliver(hallID);
			
			for(int i=0;i<orderIDList.size();i++){
				for(int j=0;j<transferList.size();j++)
					for(int k=0;k<transferList.get(j).getOrderlist().size();k++)
						if(orderIDList.get(i).equals(transferList.get(j).getOrderlist().get(k))){
							orderIDList.remove(orderIDList.get(i));
							i--;
						}
				for(int j=0;j<deliverList.size();j++)
					for(int k=0;k<deliverList.get(j).getOrderList().size();k++)
						if(orderIDList.get(i).equals(deliverList.get(j).getOrderList().get(k))){
							orderIDList.remove(orderIDList.get(i));
							i--;
						}
			}
			
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
			for(int i=0;i<orderIDList.size();i++)
				orderList.add(orderInfo.view(orderIDList.get(i)));
			
			return orderList;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void subHallTransferReceipt(String transportID, String to,
			String carID, String supervisor, String guard,
			ArrayList<OrderVO> orderlist) {
		// TODO Auto-generated method stub
		
		hallID = LoginInfo.getUserID().substring(0, 6);
		
		try {
			location = hallDataService.getLocation(hallID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			HallTransferReceiptVO vo = new HallTransferReceiptVO(hallDataService.nextHallTransferID(hallID), location, Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE, hallID, transportID, to, carID, supervisor, guard, orderlist);
			hallDataService.addHallTransfer(Convert.vo_to_po_halltransfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void subDeliverReceipt(String deliver, ArrayList<OrderVO> orderlist) {
		// TODO Auto-generated method stub
		
		hallID = LoginInfo.getUserID().substring(0, 6);
		
		try {
			location = hallDataService.getLocation(hallID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			DeliverReceiptVO vo = new DeliverReceiptVO(hallDataService.nextDeliverID(hallID),Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE,location,deliver,orderlist);
			hallDataService.addHallDeliver(Convert.vo_to_po_deliver(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceiptSubmitted() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<ArrivalReceiptPO> polist = hallDataService.getSummitArrival();
			ArrayList<ArrivalReceiptVO> volist = new ArrayList<ArrivalReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_arrival(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void approveArrivalReceipt(String id) {
		// TODO Auto-generated method stub
		try {
			hallDataService.approveHallArrival(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceipt() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<ArrivalReceiptPO> polist = hallDataService.getAllHallArrival();
			ArrayList<ArrivalReceiptVO> volist = new ArrayList<ArrivalReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_arrival(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceiptSubmitted() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<HallTransferReceiptPO> polist = hallDataService.getSummitTransfer();
			ArrayList<HallTransferReceiptVO> volist = new ArrayList<HallTransferReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_halltransfer(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void approveHallTransferReceipt(String id) {
		// TODO Auto-generated method stub
		
		try {
			hallDataService.approveHallTransfer(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceipt() {
		// TODO Auto-generated method stub		
		
		try {
			ArrayList<HallTransferReceiptPO> polist = hallDataService.getAllHallTransfer();
			ArrayList<HallTransferReceiptVO> volist = new ArrayList<HallTransferReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_halltransfer(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceiptSubmitted() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<DeliverReceiptPO> polist = hallDataService.getSummitDeliver();
			ArrayList<DeliverReceiptVO> volist = new ArrayList<DeliverReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_deliver(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void approveDeliverReceipt(String id) {
		// TODO Auto-generated method stub
		
		try {
			hallDataService.approveHallDeliver(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceipt() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<DeliverReceiptPO> polist = hallDataService.getAllHallDeliver();
			ArrayList<DeliverReceiptVO> volist = new ArrayList<DeliverReceiptVO>();
			for(int i=0;i<polist.size();i++)
				volist.add(Convert.po_to_vo_deliver(polist.get(i)));
			return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

    

}
