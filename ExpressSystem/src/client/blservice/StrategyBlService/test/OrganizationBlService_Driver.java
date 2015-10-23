package client.blservice.StrategyBlService.test;

import client.ResultMessage;
import client.blservice.StrategyBlService.OrganizationBlService;

public class OrganizationBlService_Driver {
	public void drive(OrganizationBlService ss){

		ss.viewStationList();
		
		ResultMessage rm = ss.createStation("025", "Nanjing");
		if(rm == ResultMessage.INVALID)
			System.out.println("ID exists");
		else System.out.println("Succeed");
		
		rm = ss.deleteStation("026");
		if(rm == ResultMessage.INVALID)
			System.out.println("ID  doesn't exist");
		else System.out.println("Succeed");
		
		ss.viewHallList();
		
		rm = ss.createHall("025001", "Gulou", "Nanjing");
		if(rm == ResultMessage.INVALID)
			System.out.println("ID exists");
		else System.out.println("Succeed");
		
		rm = ss.deleteStation("025002");
		if(rm == ResultMessage.INVALID)
			System.out.println("ID  doesn't exist");
		else System.out.println("Succeed");
		
	}
	
	public static void main(String[] args) {
		new OrganizationBlService_Driver().drive(new OrganizationBlService_Stub());
	}
}
