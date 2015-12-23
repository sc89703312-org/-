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
import edu.nju.express.po.HallTransferReceiptPO;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.TransferReceiptPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:39
 * 
 * 中转中心单据的业务逻辑模块，用于实现中转中心相关单据的生成提交与审批
 *
 */

public class StationReceiptBl implements StationReceiptBlService, StationInfo, StationApproveInfo{
	
    /* 中转中心模块的数据层接口 */
	StationDataService stationDataService;
	/* 营业厅模块的数据层接口 */
	HallDataService hallDataService;
	/* 获得订单信息的接口 */
	OrderInfo orderInfo;
	/* 设置订单位置的接口 */
	SetOrderSpot setOrderSpot;
	
	/* 中转中心的ID */
	String stationID;
	/* 中转中心的位置 */
	String location;
	
	/*
	 * 构造方法
	 */
	public StationReceiptBl(OrderInfo orderInfo, SetOrderSpot setOrderSpot){
		stationDataService = RMIHelper.getStationDataService();
		hallDataService = RMIHelper.getHallDataService();
		this.orderInfo= orderInfo;
		this.setOrderSpot = setOrderSpot;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.StationReceiptBlService#creatArriveReceipt(java.lang.String)
	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
	@Override
	public ArriveReceiptVO creatArriveReceipt(String id) {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		System.out.println(id+"!!");
		
		try {
			this.location = stationDataService.getLocation(stationID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id.contains("HallTransferReceipt")){
            try {
            	HallTransferReceiptPO transferpo = hallDataService.findHallTransfer(id);
            	HallTransferReceiptVO transfervo = null;
            	if(transferpo==null)
            		return null;
            	else
				    transfervo = Convert.po_to_vo_halltransfer(transferpo);
				System.out.println(location+"."+transfervo.getDestination());
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
				TransferReceiptPO transferpo = stationDataService.getTransfer(id);
				TransferReceiptVO transfervo = null;
				if(transferpo==null)
					return null;
				else
					transfervo = Convert.po_to_vo_transfer(transferpo);
				if(transfervo.getTo().equals(location)){
					ArriveReceiptVO vo = new ArriveReceiptVO(stationDataService.nextArriveID(stationID),MyDate.getCurrentDate(),transfervo.getLocation(),location,transfervo.getList());
					return vo;
				}
				else{
					System.out.println("!!!!");
					return null;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.StationReceiptBlService#subArriveReceipt(edu.nju.express.vo.ArriveReceiptVO)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.StationReceiptBlService#showCurrentOrder()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
	@Override
	public ArrayList<OrderVO> showCurrentOrder() {
		// TODO Auto-generated method stub
		
		stationID = LoginInfo.getUserID().substring(0, 3);
		
		try {
			
			ArrayList<ArriveReceiptPO> arrivelist = stationDataService.getArriveReceipt(stationID);
			ArrayList<TransferReceiptPO> transferlist = stationDataService.getTransferReceipt(stationID);
			ArrayList<OrderPO> arrivepolist = new ArrayList<OrderPO>();
			ArrayList<OrderPO> transferpolist = new ArrayList<OrderPO>();
			
			
  
            
			System.out.println("Station showCurrentOrder arrivelist:"+arrivelist.size());
			for(int i=0;i<arrivelist.size();i++){
				arrivepolist.addAll(arrivelist.get(i).getOrderList());
			}
			for(int i=0;i<transferlist.size();i++)
				transferpolist.addAll(transferlist.get(i).getOrderList());


            for(int i=0;i<arrivepolist.size();i++)
            	for(int j=0;j<transferpolist.size();j++)
            		if(arrivepolist.get(i).getId().equals(transferpolist.get(j).getId())){
            			arrivepolist.remove(i);
            			transferpolist.remove(j);
            			i--;
            			break;
            		}
            
			
			ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
			for(int i=0;i<arrivepolist.size();i++){
				orderlist.add(Convert.po_to_vo_order(arrivepolist.get(i)));
				System.out.println(orderlist.get(i).getID());
			}
			System.out.println("station show currentorder orderlist: "+orderlist.size());
			
			return orderlist;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.StationReceiptBlService#subTransferReceipt(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, edu.nju.express.common.Etype)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#approveArriveReceipt(java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
    @Override
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
	
    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#approveTransferReceipt(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
     */
    @Override
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
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#viewAllArriveReceiptSubmitted()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#viewAllTransferReceiptSubmitted()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#viewAllArriveReceipt()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo#viewAllTransferReceipt()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
	 */
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

    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.commoditybl.StationInfo#viewApproveArrive(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
     */
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

    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.commoditybl.StationInfo#viewApproveTransfer(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
     */
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

    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.commoditybl.StationInfo#handleArrive(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
     */
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

    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.commoditybl.StationInfo#handleTransfer(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:42
     */
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
