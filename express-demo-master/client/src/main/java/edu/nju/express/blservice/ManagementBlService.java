package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.EmployeeVO;



public interface ManagementBlService {
	public ArrayList<EmployeeVO> viewEmployeeList();
	
	public ResultMessage addEmployee(String id, 
			String name, Role role);
	
	public ResultMessage dismissEmployee(String id);
}
