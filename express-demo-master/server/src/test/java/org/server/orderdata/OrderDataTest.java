package org.server.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.OrderDataService_Impl;
import edu.nju.express.po.OrderPO;

public class OrderDataTest {

	OrderDataService_Impl orderData;
	
	public OrderDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			orderData = new OrderDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Before
	public void setUp(){
		System.out.println("订单数据层功能测试");
		System.out.println("——————————————————————");
		System.out.println();
	}

	@After
	public void tearDown(){
		System.out.println();
		System.out.println("结束此次测试");
		System.out.println("———————————————————————");
		
	}
	
	@Test
	public void testGetAllOrder() throws RemoteException{
		System.out.println("获取所有订单");
		
		ArrayList<OrderPO> orderLit = orderData.getAll();
		for(OrderPO po:orderLit)
			System.out.println(po.getID()+"  "+po.getCurrentSpot());
	}
}
