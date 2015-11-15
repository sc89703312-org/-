package client.businesslogic.balancebl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.balancebl.CreateCost.CostControlbl;
import client.businesslogic.paymentbl.Mock_Test.MockBanking;
import client.po.balancepo.Item;
import client.vo.balancevo.Balancevo;

public class MockCost extends CostControlbl {

	ArrayList<Balancevo>  tempList = new ArrayList<Balancevo>();
	
	
	
	
	public MockCost(MockBanking account) {
		super(account);
		// TODO Auto-generated constructor stub
		
		
		tempList.add(new Balancevo(
				"2015/11/15", 2000, 
				"XiaoS", "sc", 
				Item.BONUS, "2000"));
	
	
	
	
	    tempList.add(new Balancevo(
			"2015/11/14", 1000, 
			"XiaoW", "a", 
			Item.BONUS, "2000"));
}
	
	
	
	
	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		return tempList;
	}

}
