package client.blservice.logisticsblservice.test;

import client.blservice.logisticsblservice.LogisticsBLService;
import client.vo.logisticsvo.LogisticsVO;

public class LogisticsBLService_Stub implements LogisticsBLService{

	@Override
	public LogisticsVO view(String id) {
		// TODO Auto-generated method stub
		if(id.equals("0000012345"))
			System.out.println("Show logistic information!");
		else 
			System.out.println("This order id does not exist!");
		return null;
	}

}
