package edu.nju.express.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.logisticsbl.Info.OrderToLogisticsInfo;
import edu.nju.express.businesslogic.stationbl.Info.OrderInfo;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Convert;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.SetOrderSpot;
import edu.nju.express.dataservice.orderdataservice;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.LogisticsVO;
import edu.nju.express.vo.OrderVO;



public class OrderBL implements OrderBLService,
                                OrderInfo,SetOrderSpot,
                                OrderToLogisticsInfo
                                {
	
	orderdataservice orderdataservice;
	
	
	
	public OrderBL(){
		
		
		orderdataservice =RMIHelper.getOrderdataservice();
	}
	
	

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.OrderBLService#createOrder(edu.nju.express.vo.OrderVO)
	 */
	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		
		try {
			LogController.insertLog(new LogMessage("Create Order", LoginInfo.getUserName()));
			return orderdataservice.insert(Convert.vo_to_po_order(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.OrderBLService#view(java.lang.String)
	 */
	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		try {
			return Convert.po_to_vo_order(orderdataservice.find(id));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.OrderBLService#viewAll()
	 */
	@Override
	public ArrayList<OrderVO> viewAll() {
		// TODO Auto-generated method stub
		
		
		try {
			return Convert.po_to_vo_orderlist(orderdataservice.getAll());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.OrderBLService#receiverCfm(java.lang.String)
	 */
	@Override
	public void receiverCfm(String id) {
		// TODO Auto-generated method stub
		try {
			orderdataservice.setArrivalState(ArrivalState.YES, id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.OrderBLService#endOrder()
	 */
	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param id
	 * @return 在这里包装好VO发给LogisticsBL模块
	 */
	public LogisticsVO searchById(String id){
		
		OrderPO tempOrder = null;
		
		 try {
			tempOrder = orderdataservice.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(tempOrder!=null)
		
		return new LogisticsVO(tempOrder.getID(), 
				tempOrder.getCurrentSpot(),
				tempOrder.getDeliver(), tempOrder.viewHistory(), tempOrder.getTotalCost(),
				tempOrder.getSenderAddress(), tempOrder.getReceiverAddress(),
				tempOrder.getGoodsName());
		 
		 else {
			return null;
		}
		
	}

	/**
	 * 
	 * @param id
	 * @param currentSpot
	 * HallReceiptBL 和 StationReceiptBL 修改订单位置信息
	 */
	
	
	
	
	@Override
	public void modifySpot(String id, String currentSpot){
		try {
			orderdataservice.addHistory(currentSpot, id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.common.SetOrderSpot#setDeliver(java.lang.String, java.lang.String)
	 */
	@Override
	public void setDeliver(String id, String name) {
		// TODO Auto-generated method stub
		try {
			orderdataservice.setDeliver(name, id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
	
	
	


}
