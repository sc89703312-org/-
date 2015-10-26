package client.blservice.paymentblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.paymentblservice.Paymentblservice;
import client.blservice.receiptblservice.ReceiptBlService;
import client.vo.paymentvo.Paymentvo;

public class paymentblservice_Stub implements Paymentblservice {


	
	
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		
		ResultMessage temp = ResultMessage.VALID;
		
		
		if(vo.getCourier_id().equals("025100001"))
		{
			System.out.println("The id of courier exsits");
			
		}
		else {
			System.out.println("The id of courier doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		
		if(vo.getOrder_id().equals("0000000001"))
			System.out.println("The id of order exsits");
		else {
			System.out.println("The id of order doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		if(vo.getBankaccount().equals("sc89703312"))
			System.out.println("Account exsits");
		else {
			System.out.println("Account doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		
		if(temp==ResultMessage.VALID)
		{
			System.out.println("The id of "+vo.getBankaccount()+" cost "+vo.getPay()+" yuan.");
		}
		
		
		

		
		return temp;
	}

	
	
	
	@Override
	public Paymentvo getPayment(String id) {
		// TODO Auto-generated method stub
		
		if(id.equals("2015/9/12 00000001"))
		{
			
			System.out.println("The id of payment exsits");
		      return new Paymentvo("2015/9/12", 20.5, "025100001", "0000000001", "sc89703312");
		
		}
		else {
			System.out.println("The id of payment doesn't exsit");
		}
		return null;
	}

	@Override
	public void endPayment() {
		// TODO Auto-generated method stub
		System.out.println("Payment ends");
	}




	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
