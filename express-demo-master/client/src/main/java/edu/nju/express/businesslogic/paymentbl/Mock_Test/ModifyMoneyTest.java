package edu.nju.express.businesslogic.paymentbl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.express.businesslogic.balancebl.CreateCost.CostControlbl;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.common.Item;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;



public class ModifyMoneyTest {
/*
	@Test
	
	public void testPay(){
		BankingInfo banking =new MockBanking();
		
		
		Paymentbl payment = new Paymentbl(banking);
		
		payment.createReceipt(new Paymentvo(
				"2015/11/11", 10000, "025000001",
				"1111111111", "sc"));
		
		payment.createReceipt(new Paymentvo(
				"2015/11/11", 20000, "025000001",
				"1111111112", "a"));
		
		
		
		assertEquals(110000   , banking.getMoney("sc"));
		
		assertEquals(120000   , banking.getMoney("a"));
	}
	
	@Test
	public void testCost(){
		MockBanking banking = new MockBanking();
		
		CostControlbl costControlbl = new CostControlbl(banking);
		
		costControlbl.createCost(new Balancevo(
				"2015/11/11", -10000,
				"XiaoLi", "sc",
				Item.BONUS, "$10000"));
		
		
		costControlbl.createCost(new Balancevo(
				"2015/11/11", -20000,
				"XiaoLiu", "a",
				Item.BONUS, "$20000"));
		
		
		
		
		
		assertEquals(90000,  banking.getMoney("sc"));
		
		assertEquals(80000,  banking.getMoney("a"));
	}*/
}
