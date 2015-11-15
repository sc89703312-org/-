package client.businesslogic.balancebl.Mock_Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import client.businesslogic.balancebl.PaymentList;
import client.businesslogic.balancebl.viewpayment.ViewPaymentbl;
import client.businesslogic.paymentbl.Paymentbl;
import client.businesslogic.paymentbl.Mock_Test.MockBanking;
import client.vo.paymentvo.Paymentvo;

public class ViewPaymentsTest {

	
	Paymentbl paymentbl = new MockPayment(new MockBanking());
	
	PaymentList paymentList = new PaymentList(paymentbl);
	
	ViewPaymentbl viewPaymentbl = new ViewPaymentbl(paymentList);
	
	
	
	@Test
	public void testViewByStation(){
		
		
		ArrayList<Paymentvo> tempList = viewPaymentbl.viewByHall("025000");

		assertEquals(3,tempList.size());
		assertEquals(1000, (int)viewPaymentbl.sumPaymentByHall("025000"));
		
	}
	
	@Test
	public void testViewBydate(){
		
		ArrayList<Paymentvo> tempList = viewPaymentbl.viewByDate("2015/11/11");

		assertEquals(1,tempList.size());
		assertEquals(200, (int)viewPaymentbl.sumPaymentByDay("2015/11/11"));
		
	}
	
	
	
	
	
	
}
