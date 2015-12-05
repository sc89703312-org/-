package edu.nju.express.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.businesslogic.accountbl.Info.ManagementInfo;
import edu.nju.express.businesslogic.strategybl.managementbl.Info.UserCreateMessageInfo;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.EmployeeVO;



public class ManagementBl implements ManagementBlService{

	UserCreateMessageInfo userBL;
	
	public ManagementBl(UserCreateMessageInfo userBL) {
		this.userBL = userBL;
	}
	


	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		
		LogController.insertLog(new LogMessage("Add Employee", LoginInfo.getUserName()));
		
		return userBL.createUserMessage(StaffChange.add, id, name, role);
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		
		LogController.insertLog(new LogMessage("Dismiss Employee", LoginInfo.getUserName()));
		
		
		return userBL.createUserMessage(StaffChange.delete, id, null, null);
	}



	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return userBL.viewEmployeeList();
	}


	

}
