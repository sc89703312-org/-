package edu.nju.express.businesslogic.strategybl.managementbl.Mock;

import java.util.ArrayList;

import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;



public class MockUser extends UserBl{

	public MockUser(){
		super();
	}
	
	@Override
	public ArrayList<EmployeeVO> viewEmployeeList(){
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list.add(new EmployeeVO("025000001", "A", Role.POSTMAN));
		list.add(new EmployeeVO("025000002", "B", Role.POSTMAN));
		list.add(new EmployeeVO("025000003", "C", Role.POSTMAN));
		
		return list;
	}
	
	
	
	@Override
	public ResultMessage createUserMessage(StaffChange operation,String id,String name,Role role){
		if(operation == StaffChange.add && id.equals("025000001"))
			return ResultMessage.INVALID;
		if(operation == StaffChange.delete && !id.equals("025000001"))
			return ResultMessage.INVALID;
		return ResultMessage.VALID;
	}
}
