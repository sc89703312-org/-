package edu.nju.express.init;


import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.common.Role;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.vo.OrderVO;










public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		
		new LoginUI();		
		
//		UserBl userBl = new UserBl();
		
//		userBl.addUser("manager", "亚瑟王", Role.MANAGER, "saber");
//		userBl.addUser("postman", "小刘", Role.POSTMAN, "123");

		
		

	}
}