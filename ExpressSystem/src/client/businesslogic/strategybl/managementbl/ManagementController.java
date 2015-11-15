package client.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public class ManagementController implements ManagementBlService{

	ManagementBlService management;
	
	
	
	/**
	 * @param management
	 */
	public ManagementController(ManagementBlService management) {
		this.management = management;
	}

	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		// TODO Auto-generated method stub
		return management.viewEmployeeList();
	}

	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		// TODO Auto-generated method stub
		return management.addEmployee(id, name, role);
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		// TODO Auto-generated method stub
		return management.dismissEmployee(id);
	}

}