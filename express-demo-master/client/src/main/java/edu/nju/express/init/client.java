package edu.nju.express.init;


import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.ws.LogicalMessage;

import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.accountbl.Accountbl;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.strategybl.salarysettingbl.SalarySettingBl;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.common.Item;
import edu.nju.express.common.Role;
import edu.nju.express.log.LogController;
import edu.nju.express.po.Balancepo;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.vo.Accountvo;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.Paymentvo;
import edu.nju.express.vo.StationVO;










public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		

		
//		LogController.insertLog(new LogMessage("统计报表分析", "Echo"));

		
		
		
		
		
		ArrayList<LogMessage> messages = LogController.viewAllMsg();
		for(LogMessage message:messages)
			System.out.println(message.toString());


//		Paymentbl paymentbl = DataFactory.createPaymentBLInstance();
//		
//	    ArrayList<String> orderList = paymentbl.getOrderListByHall("025001");
//
//	    for(String order:orderList)
//	    	System.out.println(order);
	
//		new LoginUI();		

//		ConstantSettingBl constantSettingBl = DataFactory.createConstantSettingBLInstance();
//		constantSettingBl.deleteCity("北京");
//		
//	    ArrayList<String> cityDistances = ConstantSettingBl.getCityDistance();
//	    for(String list:cityDistances)
//	    	System.out.println(list);
		

	}
}