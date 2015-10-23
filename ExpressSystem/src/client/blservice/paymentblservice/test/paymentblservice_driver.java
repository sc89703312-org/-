package client.blservice.paymentblservice.test;

import client.ResultMessage;
import client.blservice.paymentblservice.Paymentblservice;
import client.vo.paymentvo.Paymentvo;

public class paymentblservice_driver {

	
	public void drive(Paymentblservice paymentBlservice)
	{
		ResultMessage resultMessage   = paymentBlservice.createReceipt(new Paymentvo("2015/9/12", 20, "025100001", "0000000001", "sc89703312"));
	
	
	if(resultMessage==ResultMessage.INVALID)
		System.out.println("Failed");
	else {
		System.out.println("Succeed");
	}
	
	paymentBlservice.endPayment();
	
	}
	
	
	public paymentblservice_driver(Paymentblservice p) {
		// TODO Auto-generated constructor stub
	
	drive(p);
	}
}
