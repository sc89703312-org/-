package client.businesslogic.balancebl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import client.businesslogic.balancebl.Balancebl;
import client.businesslogic.balancebl.CostControlbl;
import client.businesslogic.balancebl.CostList;
import client.businesslogic.balancebl.PaymentList;
import client.businesslogic.paymentbl.MockBanking;
import client.businesslogic.paymentbl.Paymentbl;

public class ViewBalanceTest {

	
	
	@Test
	public void testBalnce(){
		
		Paymentbl paymentbl = new MockPayment(new MockBanking());
		
		CostControlbl controlbl = new MockCost(new MockBanking());
	
		PaymentList paymentList = new PaymentList(paymentbl);
		
		CostList costList = new CostList(controlbl);
		
		Balancebl balancebl = new Balancebl(paymentList,costList);
		
		
		
		double temp [] = {1000,3000,-2000};


		
		
		assertArrayEquals(temp, balancebl.viewBalance(),0 );
	
}
}