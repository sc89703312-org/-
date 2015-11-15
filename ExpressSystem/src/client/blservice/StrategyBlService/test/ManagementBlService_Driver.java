package client.blservice.StrategyBlService.test;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;

public class ManagementBlService_Driver {
	public void drive(ManagementBlService ss){
		ss.viewEmployeeList();
		
		ResultMessage rm = ss.addEmployee("025000001","A",Role.POSTMAN);
		if(rm == ResultMessage.INVALID)
			System.out.println("ID exists");
		else System.out.println("Succeed");
		
		rm = ss.dismissEmployee("025000002");
		if(rm == ResultMessage.INVALID)
			System.out.println("ID  doesn't exist");
		else System.out.println("Succeed");

	}
	
	public static void main(String[] args) {
		new ManagementBlService_Driver().drive(new ManagementBlService_Stub());
	}
}
