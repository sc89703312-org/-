package edu.nju.express.init;


import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.strategybl.salarysettingbl.SalarySettingBl;
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
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.Paymentvo;
import edu.nju.express.vo.StationVO;










public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		


	
	
		new LoginUI();		

		
		


		

//		
//		try {
//		
//			System.out.println(RMIHelper.getBalanceDataService().getAll().get(1).getId());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

//		System.out.println(ConstantSettingBl.getVehicleLoad()[2]);

//		ConstantSettingBl constantSettingBl = DataFactory.createConstantSettingBLInstance();
		
		
        
        
//        ArrayList<String> cityDistance =  ConstantSettingBl.getCityDistance();
//		
//		
//        for(String distanceList:cityDistance)
//		System.out.println(distanceList);
	}
}