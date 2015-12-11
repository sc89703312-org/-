package org.server.balancedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.BalanceDataService_Impl;
import edu.nju.express.po.Balancepo;

public class BalanceDataTest {

	
	private BalanceDataService_Impl balanceData;
	
	public BalanceDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			balanceData = new BalanceDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	@Before
	public void setUp(){
		System.out.println("对付款单数据层进行功能测试");
		System.out.println("————————————————————————————————");
		System.out.println();System.out.println();
	}
	
	
	@After
	public void tearDown(){
		System.out.println();System.out.println();
		System.out.println("————————————————————————————————");
		System.out.println("结束对付款单数据层进行功能测试");
	}
	
	
	@Test
	public void testAllCost() throws RemoteException{
		System.out.println("显示所有的付款单");
		
		ArrayList<Balancepo> tempList = balanceData.getAll();
		ArrayList<Balancepo> costList = new ArrayList<>();
		costList = (tempList==null?new ArrayList<Balancepo>():tempList);
		
		for(Balancepo po:costList)
			System.out.println(po.getDate()+"      "+
		                       po.getId()+"      "+
					           po.getName()+"      "+
		                       po.getMoney()
		);
				
		
	}
	
}
