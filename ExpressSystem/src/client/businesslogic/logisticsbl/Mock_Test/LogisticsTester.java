package client.businesslogic.logisticsbl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import client.businesslogic.logisticsbl.LogisticsBL;
import client.vo.logisticsvo.LogisticsVO;

public class LogisticsTester {
	LogisticsBL logisticsBL = new LogisticsBL(new MockOrder());
	
	@Test
	public void testView(){
		
		LogisticsVO logisticsVO = logisticsBL.view("0000000001");
		
		assertEquals("Nanjing",logisticsVO.getCurrentLoca());
		
		assertEquals(1,logisticsVO.getHistory().size());
		
		assertEquals("Nanjing",logisticsVO.getHistory().get(0));
		
		assertEquals("XiaoLi" , logisticsVO.getDeliver());
		
	}
}
