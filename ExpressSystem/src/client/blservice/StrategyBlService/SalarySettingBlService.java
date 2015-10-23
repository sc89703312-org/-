package client.blservice.StrategyBlService;

import client.ResultMessage;

public interface SalarySettingBlService {
	
	public ResultMessage setClerkSalary(double salary);
	
	public ResultMessage setDriverWage(double wage);
	
	public ResultMessage setPostmanWage(double wage);
}
