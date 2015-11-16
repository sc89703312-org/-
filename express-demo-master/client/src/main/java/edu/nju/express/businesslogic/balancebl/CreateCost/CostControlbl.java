package edu.nju.express.businesslogic.balancebl.CreateCost;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.*;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.Balancepo;
import edu.nju.express.vo.Balancevo;



public class CostControlbl implements CostControlService{

	balancedataservice balancedataservice;
	
	Bankingbl account;
	

	
	
	public CostControlbl(Bankingbl account) {
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
