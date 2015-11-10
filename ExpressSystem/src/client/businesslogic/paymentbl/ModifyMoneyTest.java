package client.businesslogic.paymentbl;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModifyMoneyTest {

	@Test
	
	public void test(){
		MockBanking banking =new MockBanking();
		
		
		paymentbl payment = new paymentbl(banking);
		
		payment.modify(10000, "sc");
		
		assertEquals(110000   , banking.getMoney("sc"));
	}
}
