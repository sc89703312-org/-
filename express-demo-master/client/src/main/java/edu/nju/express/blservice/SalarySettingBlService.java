package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;



public interface SalarySettingBlService {
	
	public ResultMessage setClerkSalary(double salary);
	
	public ResultMessage setDriverWage(double wage);
	
	public ResultMessage setPostmanWage(double wage);
}
