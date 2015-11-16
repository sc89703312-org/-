package edu.nju.express.businesslogic.balancebl;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;



public class Caculate {

	
	static double answer=0;
	
	
	public static double caculatePay(ArrayList<Paymentvo> list){
		
		answer = 0;
		
		for(int i=0;i<list.size();i++)
			answer+= list.get(i).getPay();
		
		
		return answer;
	}
	
	
	public static double caculateCost(ArrayList<Balancevo> list){
		
		answer = 0;
		
		for(int i=0;i<list.size();i++)
			answer+= list.get(i).getMoney();
		
		
		return answer;
			
	}
	
	
}
