package client.blservice.balanceblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.balanceblservice.CostControlService;
import client.po.balancepo.Item;
import client.vo.balancevo.Balancevo;

public class CostControlService_Stub implements CostControlService{

	@Override
	public ResultMessage createCost(Balancevo vo) {
		// TODO Auto-generated method stub
		
		ResultMessage temp =ResultMessage.VALID;
		
		if(vo.getBanking().equals("sc89703312")){
			System.out.println("The account :"+vo.getBanking()+
					                 " exsits and has been substracted "+vo.getMoney()+" yuan");
		}else {
			System.out.println("The account doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		
		
		return temp;
	}

	@Override
	public Balancevo getCost(String id) {
		// TODO Auto-generated method stub
		
		if(id=="2015/9/12 sc89703312"){
			return new Balancevo(id.split(" ")[0], 200, "XiaoLiu", 
					                      id.split(" ")[1], Item.RENT, "2015");
		}
		
		else {
			System.out.println("The id of cost doesn't exsit");
			return null;
		}
		
	}

	@Override
	public void endCostControl() {
		// TODO Auto-generated method stub
		System.out.println("CostControl ends");
	}

	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		return null;
	}

}
