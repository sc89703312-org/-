package client.blservice.StrategyBlService.test;

import client.ResultMessage;
import client.blservice.StrategyBlService.SalarySettingBlService;

public class SalarySettingBlService_Stub implements SalarySettingBlService{

	@Override
	public ResultMessage setClerkSalary(double salary) {
		ResultMessage rm = ResultMessage.VALID;
		if(salary == 0)
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage setDriverWage(double wage) {
		ResultMessage rm = ResultMessage.VALID;
		if(wage == 0)
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage setPostmanWage(double wage) {
		ResultMessage rm = ResultMessage.VALID;
		if(wage == 0)
			rm = ResultMessage.INVALID;
		return rm;
	}
}
