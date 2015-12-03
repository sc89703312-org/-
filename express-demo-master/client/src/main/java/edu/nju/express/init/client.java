package edu.nju.express.init;

import java.util.ArrayList;

import edu.nju.express.blservice.LogisticsBLService;
import edu.nju.express.businesslogic.logisticsbl.LogisticsBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.log.LogController;
import edu.nju.express.log.ui.logmsg.LogFrame;
import edu.nju.express.po.LogMessage;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.vo.OrderVO;









public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		
       
		new Logistic_Frame();
		
		
//		OrderBL orderBL = new OrderBL();
		

//		System.out.println(orderBL.createOrder(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
//				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"0000000001",Etype.FAST,
//				ArrivalState.NO,"2 days","Nanjing-XianLin-Hall")));
		
		
		
		
//		System.out.println(orderBL.viewAll().size());
//		ArrayList<OrderVO> orders = orderBL.viewAll();
//		for(OrderVO vo:orders)
//			System.out.println(vo.getID());
//		LogisticsBLService logistics = new LogisticsBL(new OrderBL());
//		
//		System.out.println(logistics.view("1234567890").getCurrentLoca());
		
		
	}
}