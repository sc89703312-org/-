package client.businesslogic.userbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import client.ResultMessage;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public class UserTester {

	UserBl userbl = new UserBl();
	
	@Test
	public void test() {
		assertEquals(userbl.addUser("025000001", "Q", Role.ACCOUNTANT, "31531"),ResultMessage.INVALID);
		assertEquals(userbl.addUser("025000002", "M", Role.POSTMAN, "31531"),ResultMessage.VALID);
		assertEquals(userbl.addUser("025000003", "T", Role.POSTMAN, "31531"),ResultMessage.VALID);
		
		assertEquals(userbl.modifyUser("025000004", "Q", Role.ACCOUNTANT, "31531"),ResultMessage.INVALID);
		assertEquals(userbl.modifyUser("025000001", "S", Role.POSTMAN, "31531"),ResultMessage.VALID);
		
		assertEquals(userbl.deleteUser("025000005"),ResultMessage.INVALID);
		assertEquals(userbl.deleteUser("025000001"),ResultMessage.VALID);

		assertEquals(userbl.deleteUser("025000005"),ResultMessage.INVALID);
		assertEquals(userbl.deleteUser("025000001"),ResultMessage.VALID);

		ArrayList<EmployeeVO> list = userbl.viewEmployeeList();
		for(int i = 0; i < list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}
}