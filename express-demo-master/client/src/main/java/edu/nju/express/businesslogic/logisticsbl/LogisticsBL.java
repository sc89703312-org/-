package edu.nju.express.businesslogic.logisticsbl;


import java.util.Observable;

import edu.nju.express.blservice.LogisticsBLService;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.vo.LogisticsVO;
import edu.nju.express.vo.OrderVO;



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
