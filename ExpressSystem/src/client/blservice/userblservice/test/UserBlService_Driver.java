package client.blservice.userblservice.test;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.po.Role;

public class UserBlService_Driver {
	public void drive(UserBlService us){
		ResultMessage rm = us.addUser("025000001", "A", Role.POSTMAN, "1234567");
		if(rm == ResultMessage.INVALID)
			System.out.println("Failed");
		else
			System.out.println("Succeed");
		
		rm = us.modifyUser("025000001", "A", Role.POSTMAN, "1234567");
		if(rm == ResultMessage.INVALID)
			System.out.println("Failed");
		else
			System.out.println("Succeed");
		
		rm = us.deleteUser("025000001");
		if(rm == ResultMessage.INVALID)
			System.out.println("Failed");
		else
			System.out.println("Succeed");
		
	}
	
	public static void main(String[] args) {
		UserBlService us = new UserBlService_Stub();
		new UserBlService_Driver().drive(us);
	}
}
