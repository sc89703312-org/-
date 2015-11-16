package client.businesslogic.logisticsbl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.orderbl.OrderBL;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.Etype;
import client.vo.ordervo.OrderVO;

public class MockOrder extends OrderBL{
	ArrayList<OrderVO> list = new ArrayList<OrderVO>();
	public MockOrder(){
		list.add(new OrderVO("SC","NJU","NJU","025-83621002","13900001231","DY","NJU","NJU",
				"025-83621001","13900001230",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing"));
		list.get(0).setArrivalState(ArrivalState.YES);
		list.get(0).setDeliver("XiaoLi");
		
	}
	
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		if(id.equals("0000000001")){
			return list.get(0);
		
		}else{
			return null;
		}
		
	}

}
