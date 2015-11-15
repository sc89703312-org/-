package client.businesslogic.logisticsbl.Mock_Test;

import static org.junit.Assert.*;
import client.businesslogic.logisticsbl.LogisticsBL;
import client.businesslogic.orderbl.OrderBL;
import client.vo.logisticsvo.LogisticsVO;

public class LogisticsTester {
	LogisticsBL logisticsBL = new LogisticsBL();
	
	public void testView(){
		OrderBL orderBL = new MockOrder();
		LogisticsVO logisticsVO = logisticsBL.view("0000000001");
		
		assertEquals("Nanjing",logisticsVO.getCurrentLoca());
		
		assertEquals(1,logisticsVO.getHistory().size());
		
		assertEquals("Nanjing",logisticsVO.getHistory().get(0));
		
	}
}
