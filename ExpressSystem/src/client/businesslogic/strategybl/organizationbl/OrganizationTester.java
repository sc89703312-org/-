package client.businesslogic.strategybl.organizationbl;

import static org.junit.Assert.*;

import org.junit.Test;

import client.ResultMessage;

public class OrganizationTester {

	@Test
	public void test(){
		OrganizationBl bl = new OrganizationBl(new MockStation(), new MockHall());
		assertEquals(bl.createStation("025", "NJ"),ResultMessage.INVALID);
		assertEquals(bl.createStation("028", "Unknown"),ResultMessage.VALID);
		
		assertEquals(bl.createHall("025001", "NJ","025"),ResultMessage.INVALID);
		assertEquals(bl.createHall("028001", "Unknown","028"),ResultMessage.VALID);
	}
}
