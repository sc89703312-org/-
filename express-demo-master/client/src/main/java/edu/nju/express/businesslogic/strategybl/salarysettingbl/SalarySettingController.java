package edu.nju.express.businesslogic.strategybl.salarysettingbl;

import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.SalaryVO;


/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:48:31
 * 
 * 用于总经理进行人员工资制定时 界面层和业务逻辑层的交互
 */
public class SalarySettingController implements SalarySettingBlService {

	/**  工资制定的业务逻辑 */
	private SalarySettingBlService salarySettingBL;
	
	
	public SalarySettingController() {
		// TODO Auto-generated constructor stub
	
	
		salarySettingBL = DataFactory.createSalarySettingBlInstance();
	
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public ResultMessage setClerkSalary(double salary) {
		// TODO Auto-generated method stub
		return salarySettingBL.setClerkSalary(salary);
	}

	@Override
	public ResultMessage setDriverWage(double wage) {
		// TODO Auto-generated method stub
		return salarySettingBL.setDriverWage(wage);
	}

	@Override
	public ResultMessage setPostmanWage(double wage) {
		// TODO Auto-generated method stub
		return salarySettingBL.setPostmanWage(wage);
	}

	@Override
	public SalaryVO getSalary() {
		// TODO Auto-generated method stub
		return null;
	}

}
