package edu.nju.express.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.businesslogic.accountbl.Info.ManagementInfo;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;



public class ManagementBl implements ManagementBlService,ManagementInfo{

	UserBl user;
	
	public ManagementBl(UserBl user) {
		this.user = user;
	}
	


	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		return user.createUserMessage(StaffChange.add, id, name, role);
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		return user.createUserMessage(StaffChange.delete, id, null, null);
	}



	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return user.viewEmployeeList();
	}


	

}
