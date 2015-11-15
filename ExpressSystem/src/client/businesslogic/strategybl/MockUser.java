package client.businesslogic.strategybl;

import java.util.ArrayList;

import client.businesslogic.userbl.UserBl;
import client.po.Role;
import client.po.userpo.UserPO;
import client.vo.uservo.EmployeeVO;

public class MockUser extends UserBl{

	public MockUser(){
		super();
	}
	
	@Override
	public ArrayList<EmployeeVO> viewEmployeeList(){
		ArrayList<UserPO> listPo = new ArrayList<UserPO>();
		listPo.add(new UserPO("025000001", "A", Role.POSTMAN, "123456"));
		listPo.add(new UserPO("025000002", "B", Role.POSTMAN, "123456"));
		listPo.add(new UserPO("025000003", "C", Role.POSTMAN, "123456"));
		
		ArrayList<EmployeeVO> listVo = new ArrayList<EmployeeVO>();
		return listVo;
	}
}
