package client.blservice.logisticsblservice.test;

import client.blservice.logisticsblservice.LogisticsBLService;

public class LogisticsBLService_Driver {
	public void drive(LogisticsBLService ls){
		ls.view("0000012345");
		ls.view("0000000000");
	}
	
	public static void main(String[] args){
		(new LogisticsBLService_Driver()).drive(new LogisticsBLService_Stub());
	}
}
