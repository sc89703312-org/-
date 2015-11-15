package client.businesslogic.strategybl.salarysettingbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import client.ResultMessage;
import client.po.BasicValues;

public class SalarySettingTester {

	@Test
	public void test(){
		
		SalarySettingBl salary = new SalarySettingBl();

		assertEquals(salary.setClerkSalary(-1), ResultMessage.INVALID);
		
		assertEquals(salary.setClerkSalary(2000), ResultMessage.VALID);
		assertEquals(BasicValues.clerkSalary, 2000, 0);
		
		assertEquals(salary.setPostmanWage(5), ResultMessage.VALID);
		assertEquals(BasicValues.postmanWage, 5, 0);
		
		assertEquals(salary.setDriverWage(50), ResultMessage.VALID);
		assertEquals(BasicValues.driverWage, 50, 0);
	}
}