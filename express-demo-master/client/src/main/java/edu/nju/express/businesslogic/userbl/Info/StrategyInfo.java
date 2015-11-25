package edu.nju.express.businesslogic.userbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;

public interface StrategyInfo {
	
	public ArrayList<EmployeeVO> viewEmployeeList();
	
	public ResultMessage createUserMessage(StaffChange operation, String id, String name, Role role);

	
	public ResultMessage deleteUserMessage(String id);
}
