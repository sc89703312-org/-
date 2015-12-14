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
				"  ShelfPerLine"+
		zone.getShelfPerLine());
	}
}
