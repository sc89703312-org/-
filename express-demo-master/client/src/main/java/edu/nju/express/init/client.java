package edu.nju.express.init;

import java.rmi.RemoteException;

import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.Role;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.presentation.loginui.LoginUI;






public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
	
//		new LoginUI();
		
//		new UserBl().addUser("sc", "Echo", Role.ACCOUNTANT, "qblwydyqn@qq");
		
		LogController logBL = new LogController();
//		LogController.insertLog(new LogMessage("Add Order", "Tony"));
//	
//		for(int i=0;i<logBL.viewAllMsg().size();i++)
//			System.out.println(logBL.viewAllMsg().get(i).toString());
		
	}
}