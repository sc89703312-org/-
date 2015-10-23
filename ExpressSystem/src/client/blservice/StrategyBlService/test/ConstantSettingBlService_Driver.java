package client.blservice.StrategyBlService.test;

import client.ResultMessage;

public class ConstantSettingBlService_Driver {
	public void drive(ConstantSettingBlService_Stub ss){
		ResultMessage rm = ss.setDistance("025", "026", 300);
		if(rm == ResultMessage.INVALID)
			System.out.println("SetDistance failed");
		else System.out.println("Succeed");
		
		rm = ss.setPrice(23);
		if(rm == ResultMessage.INVALID)
			System.out.println("SetPrice failed");
		else System.out.println("Succeed");
		
		rm = ss.setVehicleLoad(0, 500000, 2000);
		if(rm == ResultMessage.INVALID)
			System.out.println("setVehicleLoad failed");
		else System.out.println("Succeed");
		
		rm = ss.setVehicleCost(0,0,0);
		if(rm == ResultMessage.INVALID)
			System.out.println("setVehicleCost failed");
		else System.out.println("Succeed");
	}
	
	public static void main(String[] args) {
		new ConstantSettingBlService_Driver().drive(new ConstantSettingBlService_Stub());
	}
}
