package client.businesslogic.balancebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.balanceblservice.CostControlService;
import client.businesslogic.paymentbl.MockBanking;
import client.dataservice.balancedataservice.balancedataservice;
import client.main.RMIHelper;
import client.po.balancepo.Balancepo;
import client.vo.balancevo.Balancevo;

public class CostControlbl implements CostControlService{

	balancedataservice balancedataservice;
	
	MockBanking account;
	
	
	public CostControlbl(MockBanking account) {
		// TODO Auto-generated constructor stub
	
	balancedataservice = RMIHelper.getBalanceDataService();
	
	this.account = account;
	
	}
	
	
	
	
	@Override
	public ResultMessage createCost(Balancevo vo) {
		// TODO Auto-generated method stub
		
//		try {
//			balancedataservice.insert(convertVO(vo));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		modify(vo.getBanking(), (int)vo.getMoney());
		
		
		
		
		return ResultMessage.VALID;
	}

	@Override
	public Balancevo getCost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endCostControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public Balancepo convertVO(Balancevo vo){
		return new Balancepo(vo.getDate(), vo.getMoney(), 
				                      vo.getName(), vo.getBanking(),
				                      vo.getItem(), vo.getRemark());
	}
	
	
	
	
	
	public void modify(String name,int cost){
		account.modify(cost, name);
	}
}
