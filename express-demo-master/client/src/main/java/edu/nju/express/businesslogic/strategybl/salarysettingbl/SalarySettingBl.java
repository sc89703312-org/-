package edu.nju.express.businesslogic.strategybl.salarysettingbl;

import java.rmi.RemoteException;

import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.SalaryDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.SalaryVO;
import static edu.nju.express.init.RMIHelper.salaryDataService;

/**
 * 薪水制定功能实现
 * @author Dora
 *
 */
public class SalarySettingBl implements SalarySettingBlService {

	
	
	public SalarySettingBl() {
		// TODO Auto-generated constructor stub
	
		
	}
	
	
	
	
	
	/**
	 * 设置业务员薪水
	 * @see edu.nju.express.blservice.SalarySettingBlService#setClerkSalary(double)
	 */
	@Override
	public ResultMessage setClerkSalary(double salary) {
		
		
		LogController.insertLog(new LogMessage("设定月薪", LoginInfo.getUserName()));
		
		
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

	/**
	 * 设置司机薪水
	 * @see edu.nju.express.blservice.SalarySettingBlService#setDriverWage(double)
	 */
	@Override
	public ResultMessage setDriverWage(double wage) {
		
		LogController.insertLog(new LogMessage("设定司机运费", LoginInfo.getUserName()));
		
		
		
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

	/**
	 * 设置快递员薪水
	 * @see edu.nju.express.blservice.SalarySettingBlService#setPostmanWage(double)
	 */
	@Override
	public ResultMessage setPostmanWage(double wage) {
		
		
		LogController.insertLog(new LogMessage("设置快递员提成", LoginInfo.getUserName()));
		
		
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
	
	
	/*
	 * 获得营业员薪水
	 */
	public static double getClerkSalary(){
		try {
			return salaryDataService.getClerkSalary();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * 获得司机薪水
	 */
	public static double getDriverWage(){
		try {
			return salaryDataService.getDriverWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/*
	 * 获得快递员薪水
	 */
	
	public static double getPostmanWage(){
		try {
			return salaryDataService.getPostmanWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}





	/*
	 * 获得薪水信息vo
	 */
	@Override
	public SalaryVO getSalary() {
		// TODO Auto-generated method stub
		try {
			return new SalaryVO(salaryDataService.getClerkSalary(),
					            salaryDataService.getDriverWage(), 
					            salaryDataService.getPostmanWage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
