package client.businesslogic.strategybl.salarysettingbl;

import client.ResultMessage;
import client.blservice.StrategyBlService.SalarySettingBlService;
import client.po.BasicValues;

public class SalarySettingBl implements SalarySettingBlService {

	@Override
	public ResultMessage setClerkSalary(double salary) {
		if (salary <= 0)
			return ResultMessage.INVALID;
		BasicValues.clerkSalary = salary;
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setDriverWage(double wage) {
		if (wage <= 0)
			return ResultMessage.INVALID;
		BasicValues.driverWage = wage;
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setPostmanWage(double wage) {
		if (wage <= 0)
			return ResultMessage.INVALID;
		BasicValues.postmanWage = wage;
		return ResultMessage.VALID;
	}

}
