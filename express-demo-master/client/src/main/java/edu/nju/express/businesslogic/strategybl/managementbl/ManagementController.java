package edu.nju.express.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.EmployeeVO;



public class ManagementController implements ManagementBlService{

	ManagementBlService management;
	private static ManagementController instance;
	
	
	
	/**
	 * @param management
	 */
	private ManagementController() {
		this.management = DataFactory.createManagementBlInstance();
	}

	public static ManagementController getInstance()
	{
		return instance = (instance==null)?new ManagementController():instance;
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
