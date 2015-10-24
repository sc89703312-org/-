package client.blservice.balanceblservice.test;

import client.ResultMessage;
import client.blservice.balanceblservice.CostControlService;
import client.po.balancepo.Item;
import client.vo.balancevo.Balancevo;

public class CostControlService_Driver {

	
	public void drive(CostControlService c){
		
		
		ResultMessage addMessage = c.createCost(new Balancevo("2015/1/2", 500,
				                                                      "XiaoLiu", "sc89703312",
				                                                      Item.RENT, "2015"));
		if(addMessage ==ResultMessage.VALID){
			System.out.println("Succeed");
		}else
			System.out.println("Failed");
		
		
		ResultMessage addMessage2  = c.createCost(new Balancevo("2015/1/2", 500,
				                                                      "XiaoLiu", "sc89703314",
				                                                      Item.RENT, "2015"));
		if(addMessage2 ==ResultMessage.VALID){
			System.out.println("Succeed");
		}else
			System.out.println("Failed");
		
		
		
		Balancevo b = c.getCost("2015/9/12 sc89703312");
     	if(b!=null){
		System.out.println(b.toString());
		
     	}
		
		c.endCostControl();
	}
	
	
	public static void main(String [] s){
		new CostControlService_Driver().drive(new CostControlService_Stub());
	}
}
