package client.businesslogic.accountbl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.strategybl.ManagementBl;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public class MockManagement extends ManagementBl{

	ArrayList<EmployeeVO> tempList = new ArrayList<EmployeeVO>();
	
	
	public MockManagement() {
		// TODO Auto-generated constructor stub
	
		    tempList.add(new EmployeeVO(
				"1",
				"sc",
				Role.ACCOUNTANT));
	
		
		    tempList.add(new EmployeeVO(
				"2",
				"sc",
				Role.ACCOUNTANT));
		    
		    
		    
		    tempList.add(new EmployeeVO(
				"3",
				"sc",
				Role.ACCOUNTANT));

}
	
	
	
	
	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return tempList;
	}
}
