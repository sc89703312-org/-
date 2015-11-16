package edu.nju.express.businesslogic.strategybl.salarysettingbl;

import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;



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
