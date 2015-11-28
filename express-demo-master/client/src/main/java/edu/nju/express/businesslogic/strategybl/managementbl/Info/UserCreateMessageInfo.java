package edu.nju.express.businesslogic.strategybl.managementbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;

public interface UserCreateMessageInfo {

	public ResultMessage createUserMessage(StaffChange change,String id, String name, Role role);

	public ArrayList<EmployeeVO> viewEmployeeList();
}
