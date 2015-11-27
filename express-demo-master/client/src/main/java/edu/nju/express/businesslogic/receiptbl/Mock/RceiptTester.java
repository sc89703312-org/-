package edu.nju.express.businesslogic.receiptbl.Mock;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.express.common.ReceiptState;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.ReceiptVOBase;

/*

public class RceiptTester {

	ReceiptBl receipt = new ReceiptBl();
	ArrayList<ReceiptVOBase> listVo;

	@Test
	public void testShow() {
		listVo = receipt.view();

		for (int i = 0; i < listVo.size(); i++) {
			System.out.println(listVo.get(i));
		}
		System.out.println();
	}

	@Test
	public void testApprove() {
		ArrayList<ReceiptVOBase> list = new ArrayList<ReceiptVOBase>();
		list.add(new DeliverReceiptVO("2015110100001", "025/11/03", "D", ReceiptState.SUBMITTED));
		list.add(new DeliverReceiptVO("2015110100004", "025/11/01", "D", ReceiptState.SUBMITTED));

		receipt.approve(list);

		for (int i = 0; i < list.size(); i++) {
			assertEquals((((MockHall)(receipt.hall)).listPo).get(i).getState(), ReceiptState.APPROVED);
		}
	}
}
*/