package org.server.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.CommodityDataService_Impl;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;


public class CommodityDataTest {
	
	CommodityDataService_Impl commodity ;
	
	public CommodityDataTest() {
		// TODO Auto-generated constructor stub
	
	
		try {
			commodity = new CommodityDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Before
	public void setUp(){
		System.out.println("对仓库数据进行功能测试");
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
	public void testGetComGoods() throws RemoteException{
		System.out.println("测试获取仓库内库存");
		Scanner in = new Scanner(System.in);
		String comID = in.next();
		
		
		ArrayList<ComGoodsPO> comGoodList = 
				(commodity.getComGoods(comID)==null)?
						new ArrayList<ComGoodsPO>():commodity.getComGoods(comID);
	
		for(ComGoodsPO po:comGoodList)	
			System.out.println(po.getOrder());
	}
	
	@Test
	public void testGetComLocation() throws RemoteException{
		System.out.println("测试获取仓库位置");
		Scanner in = new Scanner(System.in);
		String comID = in.next();
		
		
		System.out.println(commodity.getLocation(comID));
	
	}
	
	
	
	@Test
	public void testGetComZone() throws RemoteException{
		System.out.println("测试获取仓库空间分配");
		Scanner in = new Scanner(System.in);
		String comID = in.next();
		
		ComZonePO zone = commodity.getZone(comID);
		System.out.println("CellPerShelf: "+zone.getCellPerShelf()+
				" ShelfPerLine:"+
		zone.getShelfPerLine()+
		"PlaneSpace"+zone.getSpace()[0]+
		"TrainSpace"+zone.getSpace()[1]+
		"CarSpace"+zone.getSpace()[2]+
		"TemSpace"+zone.getSpace()[3]);
	}
	
	@Test
	public void testGetEnter() throws RemoteException{
		
		System.out.println("测试获取仓库入库单");
		
		Scanner sc = new Scanner(System.in);
		String comID = sc.next();
		
		ArrayList<EnterReceiptPO> list = commodity.getEnterReceipt(comID);
		for(int i=0;i<list.size();i++){
			System.out.println("入库单ID："+list.get(i).getId());
			System.out.println("货物数量："+list.get(i).getGoods().size());
		}
		
	}
	
	@Test
	public void testGetExit() throws RemoteException{
		
		System.out.println("测试获取仓库出库单");
		
		Scanner sc = new Scanner(System.in);
		String comID = sc.next();
		
		ArrayList<ExitReceiptPO> list = commodity.getExitReceipt(comID);
		for(int i=0;i<list.size();i++){
			System.out.println("出库单ID："+list.get(i).getId());
			System.out.println("货物数量："+list.get(i).getGoods().size());
		}
		
	}
	
}
