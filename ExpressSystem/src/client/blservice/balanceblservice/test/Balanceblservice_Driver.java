package client.blservice.balanceblservice.test;

import java.util.ArrayList;

import client.blservice.balanceblservice.Balanceblservice;
import client.vo.paymentvo.Paymentvo;

public class Balanceblservice_Driver {

	
	public void drive(Balanceblservice b){
		
		
		double[] temp =b.viewBalance();
		for(int i=0;i<3;i++){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		ArrayList<Paymentvo> temp_1 = b.viewReport("2015/10/22", "2015/10/23");
		for(int i=0;i<temp_1.size();i++){
			System.out.println(temp_1.get(i).toString());
			System.out.println();
		}
		
		
		b.endBalance();
	}
	
	public static void main(String[] s){
		new Balanceblservice_Driver().drive(new Balanceblservice_Stub());
	}
	
}
