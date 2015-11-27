package edu.nju.express.businesslogic.orderbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.stationbl.Info.OrderInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.orderdataservice;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.LogisticsVO;
import edu.nju.express.vo.OrderVO;



public class OrderBL implements OrderBLService, OrderInfo{
	
	orderdataservice orderdataservice;
	
	
	
	public OrderBL(){
		
		
		orderdataservice =RMIHelper.getOrderdataservice();
	}
	
	

	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void receiverCfm(String id) {
		// TODO Auto-generated method stub
		
	}

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
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param currentSpot
	 * HallReceiptBL 和 StationReceiptBL 修改订单位置信息
	 */
	public void modifySpot(String id, String currentSpot){
		
	}
	
	
	


}
