package client.businesslogic.logisticsbl;


import client.blservice.logisticsblservice.LogisticsBLService;
import client.businesslogic.orderbl.OrderBL;
import client.vo.logisticsvo.LogisticsVO;
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
		logisticsVO = new LogisticsVO(currentLoca);
		logisticsVO.addHistory(currentLoca);
		
		return logisticsVO;
	}

}
