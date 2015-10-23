package client.blservice.StrategyBlService.test;

import client.ResultMessage;
import client.blservice.StrategyBlService.SalarySettingBlService;

public class SalarySettingBlService_Driver {
	public void drive(SalarySettingBlService ss){
		
		ResultMessage rm = ss.setClerkSalary(0);
		if(rm == ResultMessage.INVALID)
			System.out.println("Salary invalid");
		else System.out.println("Succeed");
		
		rm = ss.setDriverWage(20);
		if(rm == ResultMessage.INVALID)
			System.out.println("Wage invalid");
		else System.out.println("Succeed");
		
		rm = ss.setPostmanWage(20);
		if(rm == ResultMessage.INVALID)
			System.out.println("Wage invalid");
		else System.out.println("Succeed");
	}
	
	public static void main(String[] args) {
		new SalarySettingBlService_Driver().drive(new SalarySettingBlService_Stub());
	}
}
