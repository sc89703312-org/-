package client.businesslogic.strategybl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public class ManagementBl implements ManagementBlService{

	MockUser mockUser;
	
	public ManagementBl() {
		mockUser = new MockUser();
	}
	


	@Override
	public ResultMessage addEmployee(String id, String name, Role role, String password) {
		return null;
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		return null;
	}



	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return mockUser.viewEmployeeList();
	}

}
