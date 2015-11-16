package edu.nju.express.businesslogic.logisticsbl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.express.businesslogic.logisticsbl.LogisticsBL;
import edu.nju.express.vo.LogisticsVO;



public class LogisticsTester {
	LogisticsBL logisticsBL = new LogisticsBL(new MockOrder());
	
	@Test
	public void testView(){
		
		LogisticsVO logisticsVO = logisticsBL.view("0000000001");
		
		assertEquals("Guangdong",logisticsVO.getCurrentLoca());
		
		assertEquals(4,logisticsVO.getHistory().size());
		
		assertEquals("Nanjing",logisticsVO.getHistory().get(0));
		
		assertEquals("XiaoLi" , logisticsVO.getDeliver());
		
	}
}
