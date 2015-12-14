package org.server.vehicledata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.VehicleDataService_Impl;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;

public class VehicleDataTest {
	
	
	VehicleDataService_Impl vehicle;
	
	public VehicleDataTest() {
		// TODO Auto-generated constructor stub
	
	
		try {
			vehicle = new VehicleDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	
	
	
	@Before
	public void setUp(){
		System.out.println("司机车辆数据层功能测试");
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
	public void testAllDrivers() throws RemoteException{
		System.out.println("获取所有司机信息");
		ArrayList<Driverpo> drivers = vehicle.getAllDrivers();
		for(Driverpo po:drivers)
			System.out.println(po.getId()+"    "+po.getName());
	}
	
	
	
	@Test
	public void testAllCars() throws RemoteException{
		System.out.println("获取所有车辆信息");
		ArrayList<Carpo> cars = vehicle.getAllCars();
		for(Carpo po:cars)
			System.out.println(po.getId()+"    "+po.getCar());
	}
	
}
