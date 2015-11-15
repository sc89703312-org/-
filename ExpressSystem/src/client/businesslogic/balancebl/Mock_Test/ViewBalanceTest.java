package client.businesslogic.balancebl.Mock_Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import client.businesslogic.balancebl.PaymentList;
import client.businesslogic.balancebl.CreateCost.CostControlbl;
import client.businesslogic.balancebl.CreateCost.CostList;
import client.businesslogic.balancebl.balance.Balancebl;
import client.businesslogic.paymentbl.Paymentbl;
import client.businesslogic.paymentbl.Mock_Test.MockBanking;
import client.po.paymentpo.Paymentpo;
import client.vo.balancevo.Balancevo;
import client.vo.paymentvo.Paymentvo;

public class ViewBalanceTest {

	Paymentbl paymentbl = new MockPayment(new MockBanking());
	
	CostControlbl controlbl = new MockCost(new MockBanking());

	PaymentList paymentList = new PaymentList(paymentbl);
	
	CostList costList = new CostList(controlbl);
	
	Balancebl balancebl = new Balancebl(paymentList,costList);
	
	
	
	@Test
	public void testBalnce(){

		double temp [] = {1000,3000,-2000};

		assertArrayEquals(temp, balancebl.viewBalance(),0 );
	
}
	
	
	
	@Test
	public void testViewReport(){
		
		ArrayList<Paymentvo> tempList =   balancebl.viewReport("2015/11/09", "2015/11/11");
		
		assertEquals(3,tempList.size());
		
		
	}
	
	
	@Test
	public void testViewCost(){
		
		ArrayList<Balancevo> tempList = balancebl.viewCost("2015/11/14", "2015/11/15");
		
		assertEquals(2, tempList.size());
	}
	
	
	
}