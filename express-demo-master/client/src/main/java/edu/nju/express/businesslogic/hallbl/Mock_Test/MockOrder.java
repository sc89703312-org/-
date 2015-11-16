package edu.nju.express.businesslogic.hallbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.vo.OrderVO;



public class MockOrder extends OrderBL{
	ArrayList<OrderVO> list = new ArrayList<OrderVO>();
	public MockOrder(){
		list.add(new OrderVO("SC","NJU","NJU","025-83621002","13900001231","DY","NJU","NJU",
				"025-83621001","13900001230",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing"));
		list.add(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU","NJU",
				"025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing"));
		list.add(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","THU","THU",
				"025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing"));
	}
	
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		if(id.equals("0000000001")){
			return list.get(0);
		}else if(id.equals("0000000002")){
			return list.get(1);
		}else{
			return list.get(2);
		}
		
	}
}
