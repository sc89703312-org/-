package client.businesslogic.balancebl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import client.businesslogic.balancebl.Balancebl;
import client.businesslogic.balancebl.PaymentList;
import client.businesslogic.paymentbl.MockBanking;
import client.businesslogic.paymentbl.Paymentbl;

public class ViewBalanceTest {

	
	
	@Test
	public void testBalnce(){
		
		Paymentbl paymentbl = new MockPayment(new MockBanking());
	
		PaymentList paymentList = new PaymentList(paymentbl);
		
		Balancebl balancebl = new Balancebl(paymentList);
		
		
		
		double temp [] = {1000,0,0};


		
		
		assertArrayEquals(temp, balancebl.viewBalance(),0 );
	
}
}