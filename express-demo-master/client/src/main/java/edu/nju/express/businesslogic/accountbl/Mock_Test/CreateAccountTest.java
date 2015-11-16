package edu.nju.express.businesslogic.accountbl.Mock_Test;

import org.junit.Test;

import edu.nju.express.businesslogic.accountbl.Accountbl;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Mock_Test.MockBanking;
import edu.nju.express.businesslogic.strategybl.managementbl.ManagementBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.vehiclebl.CarControl;



public class CreateAccountTest {

	
	ManagementBl managementBl = new MockManagement();
	OrganizationBl organizationBl = new MockOrganization();
	Bankingbl bankingbl = new MockBanking();
	CarControl carControl = new MockVehicle();
	
	Accountbl accountbl  =new Accountbl(managementBl, organizationBl, carControl, bankingbl);
	
	
	
	@Test
	public void testCreateAccount(){
		
	}
}
