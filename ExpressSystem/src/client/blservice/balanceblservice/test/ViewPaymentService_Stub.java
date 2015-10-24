package client.blservice.balanceblservice.test;

import java.util.ArrayList;

import client.blservice.balanceblservice.ViewPaymentService;
import client.vo.paymentvo.Paymentvo;

public class ViewPaymentService_Stub implements ViewPaymentService {

	@Override
	public ArrayList<Paymentvo> viewByHall(String number) {
		// TODO Auto-generated method stub
		
		if(number.equals("025000")){
			System.out.println("The id of hall exsits");
			ArrayList<Paymentvo> temp = new ArrayList<Paymentvo>();
			
			temp.add(new Paymentvo("2015/9/12", 20, 
					                            number, "0000000001",
					                            "sc89703312"));
			
			temp.add(new Paymentvo("2015/9/12", 20, 
					                            number, "0000000101",
					                            "sc89703312"));
			
			return temp;
		}else {
			System.out.println("The id of hall doesn't exsit");
			return null;
		}
		
	
	}

	@Override
	public ArrayList<Paymentvo> viewByDate(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentvo> temp = new ArrayList<Paymentvo>();
		
		temp.add(new Paymentvo(date, 25, 
				                            "025000100", "00000000001", 
				                            "sc89703312"));
		temp.add(new Paymentvo(date, 25, 
                                           "025000100", "00000000101", 
                                            "sc89703312"));
		
		return temp;
	}

	@Override
	public double sumPaymentByHall(String number) {
		// TODO Auto-generated method stub
		
		double sum = 0;
		ArrayList<Paymentvo> temp = viewByHall(number);
		for(int i=0;i<temp.size();i++){
			sum+=temp.get(i).getPay();
		}
		
		
		
		return sum;
	}

	@Override
	public double sumPaymentByDay(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentvo> temp = viewByDate(date);
		
		
		double sum =0 ;
		for(int i=0;i<temp.size();i++){
			sum+=temp.get(i).getPay();
		}
		
		return sum;
	}

	@Override
	public void endView() {
		// TODO Auto-generated method stub
		System.out.println("The view ends");
	}

}
