package client.businesslogic.accountbl;

import client.ResultMessage;
import client.blservice.accountblservice.Accountblservice;
import client.businesslogic.bankingbl.Bankingbl;
import client.businesslogic.strategybl.ManagementBl;
import client.businesslogic.strategybl.OrganizationBl;
import client.businesslogic.vehiclebl.CarControl;
import client.vo.accountvo.Accountvo;


public class Accountbl implements Accountblservice{

	ManagementBl managementBl;
	OrganizationBl organizationBl;
	CarControl carControl;
	Bankingbl bankingbl;
	
	
	
	
	public Accountbl(ManagementBl managementBl,
			         OrganizationBl organizationBl,
			         CarControl carControl,
			         Bankingbl bankingbl) {
		// TODO Auto-generated constructor stub
	
	
		this.managementBl = managementBl;
		this.organizationBl = organizationBl;
		this.carControl = carControl;
		this.bankingbl = bankingbl;
	
	
	
	
	}
	
	
	
	
	@Override
	public ResultMessage createAccount(Accountvo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accountvo viewAccount(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		
	}

}
