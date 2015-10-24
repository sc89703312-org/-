package client.blservice.balanceblservice.test;

import java.util.ArrayList;

import client.blservice.balanceblservice.ViewPaymentService;
import client.vo.paymentvo.Paymentvo;

public class ViewPaymentService_Driver {

	
	public void drive(ViewPaymentService v){
		
		ArrayList<Paymentvo> temp_1 = v.viewByHall("025000");
		for(int i=0;i<temp_1.size();i++){
			System.out.println(temp_1.get(i).toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		ArrayList<Paymentvo> temp_2 = v.viewByDate("2015/9/12");
		for(int i=0;i<temp_2.size();i++){
			System.out.println(temp_2.get(i).toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		double sumOfHall = v.sumPaymentByHall("025000");
		System.out.println("Sum of hall is :"+sumOfHall);
		double sumOfDate = v.sumPaymentByDay("2015/9/12");
		System.out.println("Sum of date is : "+sumOfDate);
		
		
		
		v.endView();
		
		
	}
	
	
	public static void main(String[] s){
		new ViewPaymentService_Driver().drive(new ViewPaymentService_Stub());
	}
}
