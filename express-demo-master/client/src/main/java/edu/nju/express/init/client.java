package edu.nju.express.init;


import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.vo.OrderVO;










public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		
		new LoginUI();		
		

		
		
		
		
		
       

		
		
//		OrderBL orderBL = new OrderBL();
//		orderBL.modifySpot("0000000004", "南京中转站");
//		orderBL.modifySpot("0000000004", "北京中转站");
//		orderBL.modifySpot("0000000004", "北京朝阳营业厅");
		

//		System.out.println(orderBL.createOrder(new OrderVO("SHRF","南京","南京","025-83621002","13900001234","SC","北京",
//				"北京","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"0000000004",Etype.FAST,
//				ArrivalState.NO,"2 days"," 南京浦口营业厅")));
		
		
		
		
//		System.out.println(orderBL.viewAll().size());
//		ArrayList<OrderVO> orders = orderBL.viewAll();
//		for(OrderVO vo:orders)
//			System.out.println(vo.getID());
//		LogisticsBLService logistics = new LogisticsBL(new OrderBL());
//		
//		System.out.println(logistics.view("1234567890").getCurrentLoca());
		
		
	}
}