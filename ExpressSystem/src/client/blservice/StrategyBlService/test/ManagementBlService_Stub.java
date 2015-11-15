package client.blservice.StrategyBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.vo.uservo.EmployeeVO;
import client.vo.uservo.UserVO;

public class ManagementBlService_Stub implements ManagementBlService{

	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		System.out.println("Show the list of all the employees");
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list.add(new EmployeeVO("025000001","A",Role.POSTMAN));
		return list;
	}

	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		ResultMessage rm = ResultMessage.VALID;
		if(id.equals("025000001"))
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		ResultMessage rm = ResultMessage.INVALID;
		if(id.equals("025000001"))
			rm = ResultMessage.VALID;
		return rm;
	}
}
