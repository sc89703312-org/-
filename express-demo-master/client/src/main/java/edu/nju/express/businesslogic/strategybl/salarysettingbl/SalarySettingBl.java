package edu.nju.express.businesslogic.strategybl.salarysettingbl;

import java.rmi.RemoteException;

import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.SalaryDataService;
import edu.nju.express.init.RMIHelper;



public class SalarySettingBl implements SalarySettingBlService {

	
	public static SalaryDataService salaryDataService= RMIHelper.getSalaryDataService();
	
	public SalarySettingBl() {
		// TODO Auto-generated constructor stub
	
		
	}
	
	
	
	
	
	
	@Override
	public ResultMessage setClerkSalary(double salary) {
		if (salary <= 0)
			return ResultMessage.INVALID;
//		BasicValues.clerkSalary = salary;
		try {
			salaryDataService.setClerkSalary(salary);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setDriverWage(double wage) {
		if (wage <= 0)
			return ResultMessage.INVALID;
//		BasicValues.driverWage = wage;
		try {
			salaryDataService.setDriverWage(wage);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setPostmanWage(double wage) {
		if (wage <= 0)
			return ResultMessage.INVALID;
//		BasicValues.postmanWage = wage;
		try {
			salaryDataService.setPostmanWage(wage);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}
	
	
	
	public static double getClerkSalary(){
		try {
			return salaryDataService.getClerkSalary();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static double getDriverWage(){
		try {
			return salaryDataService.getDriverWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	public static double getPostmanWage(){
		try {
			return salaryDataService.getPostmanWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
