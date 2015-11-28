package edu.nju.express.businesslogic.hallbl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.express.businesslogic.hallbl.HallReceiptBL;
import edu.nju.express.common.GoodsState;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.vo.ArrivalReceiptVO;

public class CreateReceiptTester {
	/*
	@Test
	public void testArrival(){
		MockOrder order = new MockOrder();
		HallReceiptBL hallReceiptBL = new HallReceiptBL(order, new MockVehicle());
		ArrivalReceiptVO avo = new ArrivalReceiptVO("12345", "2015/11/16", "Nanjing", "Shanghai", 
				GoodsState.COMPLETE,ReceiptState.SUBMITTED);
		avo.addOrderItem(order.view("0000000001"));
		hallReceiptBL.createArrivalReceipt(avo);
		assertEquals("Shanghai",order.view("0000000001").getCurrentSpot());
		
	}
	*/
}
