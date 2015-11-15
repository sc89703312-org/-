package client.businesslogic.strategybl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.vo.uservo.UserVO;

public class ManagementBl implements ManagementBlService{

	MockUser mockUser;
	
	public ManagementBl() {
		mockUser = new MockUser();
	}
	
	@Override
	public ArrayList<UserVO> viewEmployeeList() {
		mockUser.
		return null;
	}

	@Override
	public ResultMessage addEmployee(String id, String name, Role role, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage dismissEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
