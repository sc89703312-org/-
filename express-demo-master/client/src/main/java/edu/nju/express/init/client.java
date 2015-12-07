package edu.nju.express.init;


import java.rmi.RemoteException;

import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.common.Item;
import edu.nju.express.common.Role;
import edu.nju.express.po.Balancepo;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.Paymentvo;










public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		new UserBl().addUser("finance", "Tiny", Role.ACCOUNTANT, "hhh");

		
		new LoginUI();		
		




	}
}