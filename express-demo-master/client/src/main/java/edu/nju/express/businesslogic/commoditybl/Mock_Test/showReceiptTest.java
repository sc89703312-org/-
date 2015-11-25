package edu.nju.express.businesslogic.commoditybl.Mock_Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.express.businesslogic.commoditybl.CommodityBl;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;
/*
public class showReceiptTest {

	StationReceiptBl stationReceiptBl = new MockStation();
	CommodityBl commodityBl = new CommodityBl(stationReceiptBl);
	
	@Test
	public void testShowArriveReceipt(){
		
		ArrayList<ArriveReceiptVO> arriveList = commodityBl.showArriveReceiptList();
		ArriveReceiptVO vo = arriveList.get(0);
		
		assertEquals("000000001",vo.getID());
		
	}
	
	@Test
	public void testShowTransferReceipt(){
		
		ArrayList<TransferReceiptVO> transferList = commodityBl.showTransferReceiptList();
		TransferReceiptVO vo = transferList.get(0);
		
		assertEquals("000000002",vo.getID());
		
	}
	
}
*/
