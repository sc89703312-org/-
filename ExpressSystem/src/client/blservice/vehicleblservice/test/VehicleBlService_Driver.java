package client.blservice.vehicleblservice.test;

import client.ResultMessage;
import client.blservice.vehicleblservice.Vehicleblservice;
import client.vo.drivervo.Drivervo;

public class VehicleBlService_Driver {

	
	public void drive(Vehicleblservice vehicleblservice){
	
	    Drivervo temp = vehicleblservice.viewDriver(025000000);
	    System.out.println();
	    System.out.println();
	    
	    
	    ResultMessage addMessage_1 = vehicleblservice.addDriver(new Drivervo(025000101,"XiaoLiu",
                "1997/5/18","321283199607110010",
                "87711863","025000",true,"2015/12/12"));

	    if(addMessage_1==ResultMessage.VALID)
	    	System.out.println("Succeed");
	    else {
			System.out.println("Failed");
		}
	    
	    System.out.println();
	    System.out.println();
	    
	    
	    
	    ResultMessage addMessage_2 = vehicleblservice.addDriver(new Drivervo(025000100,"XiaoLi",
                "1997/5/18","321283199607110010",
                 "87711863","025000",true,"2015/12/12"));
	    if (addMessage_2==ResultMessage.VALID) {
	    	System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
	    System.out.println();
	    System.out.println();
	    
	    
	    
	    
	    ResultMessage deleteMessage_1 = vehicleblservice.deleteDriver(025000000);
	    if(deleteMessage_1==ResultMessage.VALID){
	    	System.out.println("Succeed");
	    }else {
			System.out.println("Failed");
		}
	    
	    System.out.println();
	    System.out.println();
	    
	    
	    ResultMessage deleteMessage_2 = vehicleblservice.deleteDriver(025000101);
	    if(deleteMessage_2==ResultMessage.VALID){
	    	System.out.println("Succeed");
	    }else {
			System.out.println("Failed");
		}
	    
	    System.out.println();
	    System.out.println();
	    
	    ResultMessage modifyMessage = vehicleblservice.modifyDriver(025000000, new Drivervo(025000101,
	    		                                                                         "XiaoLiu","1997/5/18","321283199607110010",
	    		                                                                         "87711863","025000",true,"2015/12/12"));
	    if(modifyMessage==ResultMessage.VALID){
	    	System.out.println("Succeed");
	    }else {
			System.out.println("Failed");
		}
	    
	    System.out.println();
	    System.out.println();
	    vehicleblservice.endVehicle();
	    
	}
	
	
	public VehicleBlService_Driver(Vehicleblservice v) {
		// TODO Auto-generated constructor stub
	
	drive(v);
	}
}
