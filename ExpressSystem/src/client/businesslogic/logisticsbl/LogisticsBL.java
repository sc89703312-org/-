package client.businesslogic.logisticsbl;


import java.util.Observable;

import client.blservice.logisticsblservice.LogisticsBLService;
import client.businesslogic.orderbl.OrderBL;
import client.vo.logisticsvo.LogisticsVO;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.OrderVO;

public class LogisticsBL implements LogisticsBLService{

	OrderBL orderBL;
	
	public LogisticsBL(OrderBL orderBL){
		this.orderBL=orderBL;
		
	}
	
	@Override
	public LogisticsVO view(String id) {
		// TODO Auto-generated method stub
		OrderVO orderVO = orderBL.view(id);
		LogisticsVO logisticsVO;
		String currentLoca = orderVO.getCurrentSpot();
		logisticsVO = new LogisticsVO(id,currentLoca,(Observable)orderVO);
		logisticsVO.addHistory(currentLoca);
		orderVO.setCurrentSpot("Beijing");
		orderVO.setArrivalState(ArrivalState.YES);
		orderVO.setDeliver("XiaoLi");
		orderVO.setCurrentSpot("Shanghai");
		orderVO.setCurrentSpot("Guangdong");
		
//		System.out.println(logisticsVO.getHistory());
		
		return logisticsVO;
	}

}
