package edu.nju.express.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;



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
