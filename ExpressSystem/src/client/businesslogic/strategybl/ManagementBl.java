package client.businesslogic.strategybl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.po.StaffChange;
import client.vo.uservo.EmployeeVO;

public class ManagementBl implements ManagementBlService{

	MockUser mockUser;
	
	public ManagementBl() {
		mockUser = new MockUser();
	}
	


	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		return mockUser.createUserMessage(StaffChange.add, id, name, role);
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		return mockUser.createUserMessage(StaffChange.delete, id, null, null);
	}


	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return mockUser.viewEmployeeList();
	}

}
