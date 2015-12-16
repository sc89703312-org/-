package org.server.halldata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.HallDataService_Impl;
import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallTransferReceiptPO;

public class HallDataTest {

	HallDataService_Impl impl;
	
	public HallDataTest(){
		
		try {
			impl = new HallDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Before
	public void setUp(){
		System.out.println("对营业厅数据进行功能测试");
		System.out.println("——————————————————————");
		System.out.println();
	}
	
	@After
	public void tearDown(){
		System.out.println();
		System.out.println("——————————————————————");
		System.out.println("结束此次功能测试");
	}
	
	@Test
	public void testGetHallLocation() throws RemoteException{
		
		System.out.println("测试获取营业厅位置");
		
		Scanner sc = new Scanner(System.in);
		String hallID = sc.next();
		
		System.out.println(impl.getLocation(hallID));
		
	}
	
	@Test
	public void testGetArrival() throws RemoteException{
		
		System.out.println("测试获取营业厅到达单");
		
		Scanner sc = new Scanner(System.in);
		String hallID = sc.next();
		
		ArrayList<ArrivalReceiptPO> list = impl.getAllHallArrival(hallID);
		for(int i=0;i<list.size();i++){
			System.out.println("到达单ID："+list.get(i).getId());
			System.out.println("货物来源："+list.get(i).getFrom());
			System.out.println("货物数量："+list.get(i).getOrderList().size());
		}
		
	}
	
	
	@Test
	public void testGetHallTransfer() throws RemoteException{
		
		System.out.println("测试获取营业厅装车单");
		
		Scanner sc = new Scanner(System.in);
		String hallID = sc.next();
		
		ArrayList<HallTransferReceiptPO> list = impl.getAllHallTransfer(hallID);
		for(int i=0;i<list.size();i++){
			System.out.println("装车单ID："+list.get(i).getId());
			System.out.println("货物目的地："+list.get(i).getDestination());
			System.out.println("货物数量："+list.get(i).getOrderlist().size());
		}
		
	}
	
	@Test
	public void testGetHallDeliver() throws RemoteException{
		
		System.out.println("测试获取营业厅装车单");
		
		Scanner sc = new Scanner(System.in);
		String hallID = sc.next();
		
		ArrayList<DeliverReceiptPO> list = impl.getAllHallDeliver(hallID);
		for(int i=0;i<list.size();i++){
			System.out.println("派送单ID："+list.get(i).getId());
			System.out.println("货物派送员："+list.get(i).getDeliver());
			System.out.println("货物数量："+list.get(i).getOrderList().size());
		}
		
	}
	
	
}
