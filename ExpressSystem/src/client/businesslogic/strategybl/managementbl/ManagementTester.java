package client.businesslogic.strategybl.managementbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import client.ResultMessage;
import client.blservice.StrategyBlService.ManagementBlService;
import client.po.Role;
import client.vo.uservo.EmployeeVO;

public class ManagementTester {

	ManagementBlService manage = new ManagementBl();

	@Test
	public void testView() {
		ArrayList<EmployeeVO> list = manage.viewEmployeeList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void testAdd() {
		assertEquals(manage.addEmployee("025000001", "A", Role.ACCOUNTANT), ResultMessage.INVALID);
		assertEquals(manage.addEmployee("025000004", "D", Role.ACCOUNTANT), ResultMessage.VALID);
	}
	
	@Test
	public void testDelete() {
		assertEquals(manage.dismissEmployee("025000001"), ResultMessage.VALID);
		assertEquals(manage.dismissEmployee("025000004"), ResultMessage.INVALID);
	}
}