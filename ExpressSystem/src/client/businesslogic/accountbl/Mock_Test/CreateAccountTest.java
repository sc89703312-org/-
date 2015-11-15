package client.businesslogic.accountbl.Mock_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import client.businesslogic.accountbl.Accountbl;
import client.businesslogic.bankingbl.Bankingbl;
import client.businesslogic.paymentbl.Mock_Test.MockBanking;
import client.businesslogic.strategybl.ManagementBl;
import client.businesslogic.strategybl.OrganizationBl;
import client.businesslogic.vehiclebl.CarControl;

public class CreateAccountTest {

	
	ManagementBl managementBl = new MockManagement();
	OrganizationBl organizationBl = new MockOrganization();
	Bankingbl bankingbl = new MockBanking();
	CarControl carControl = new MockVehicle();
	
	Accountbl accountbl  = new Accountbl(managementBl, organizationBl, carControl, bankingbl);
	
	
	@Test
	public void testCreateAccount(){
		accountbl.createAccount();
		assertEquals("2015/11/15",accountbl.showDate());
	}
}
