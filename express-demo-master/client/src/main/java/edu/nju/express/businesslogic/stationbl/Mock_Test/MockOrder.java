package edu.nju.express.businesslogic.stationbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.vo.OrderVO;

public class MockOrder extends OrderBL{

	ArrayList<OrderVO> list = new ArrayList<OrderVO>();
	
	public MockOrder(){
		OrderVO vo = new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing");
		list.add(vo);
	}
	
	public OrderVO view(String id){
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getID().equals(id))
				return list.get(i);
		}
		
		return null;
		
	}
	
}
