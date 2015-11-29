package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.SalaryVO;



public interface SalarySettingBlService {
	
	public ResultMessage setClerkSalary(double salary);
	
	public ResultMessage setDriverWage(double wage);
	
	public ResultMessage setPostmanWage(double wage);
	
	public SalaryVO getSalary();
}
