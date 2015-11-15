package client.blservice.StrategyBlService;

import java.util.ArrayList;

import client.ResultMessage;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public interface ManagementBlService {
	public ArrayList<EmployeeVO> viewEmployeeList();
	
	public ResultMessage addEmployee(String id, 
			String name, Role role, String password);
	
	public ResultMessage dismissEmployee(String id);
}
