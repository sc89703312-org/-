package client.blservice.vehicleblservice.test;

import client.blservice.vehicleblservice.CarControlService;
import client.blservice.vehicleblservice.Vehicleblservice;

public class test {

	public static void main(String[] s){
//		Vehicleblservice vehicleblservice = new VehicleBlService_Stub();
//    	new VehicleBlService_Driver(vehicleblservice);
    	CarControlService carControlService = new CarControlService_Stub();
    	new CarControlService_Driver(carControlService);
    	
	}
}
