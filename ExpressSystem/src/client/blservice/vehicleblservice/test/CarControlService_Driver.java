package client.blservice.vehicleblservice.test;

import java.util.Locale.Category;

import client.ResultMessage;
import client.blservice.vehicleblservice.CarControlService;
import client.vo.carvo.Carvo;

public class CarControlService_Driver {

	public void drive(CarControlService c){
		ResultMessage addMessage_1 = c.addCar(new Carvo(02500001, "motor-1", 
				                                                             "À’A-8977", "base-2", 
				                                                             "2012/8/1", 3));
		if(addMessage_1==ResultMessage.VALID){
			System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
		System.out.println();
		System.out.println();
		
		
		
		ResultMessage addMessage_2 = c.addCar(new Carvo(02500021 ,"Motor-1",
				                                                             "À’B-0012", "Base-2", 
				                                                             "2011/1/1", 4));
		if(addMessage_2==ResultMessage.VALID){
			System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
		System.out.println();
		System.out.println();
		
		
		
		ResultMessage deleteMessage = c.deleteCar(02500001);
		if(deleteMessage==ResultMessage.VALID){
			System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
		
		System.out.println();
		System.out.println();
		
		
		ResultMessage deleMessage_2 = c.deleteCar(02500050);
		if(deleMessage_2==ResultMessage.VALID){
			System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
		System.out.println();
		System.out.println();
		
		ResultMessage modifyMessage = c.modifyCar(02500001, new Carvo(02500021 ,"Motor-1",
				                                                                                    "À’B-0012", "Base-2", 
				                                                                                    "2011/1/1", 4));
		if(modifyMessage==ResultMessage.VALID){
			System.out.println("Suceed");
		}else {
			System.out.println("Failed");
		}
		
		
		
	}
	
	
	public CarControlService_Driver(CarControlService c) {
		// TODO Auto-generated constructor stub
	
	drive(c);
	}
}
