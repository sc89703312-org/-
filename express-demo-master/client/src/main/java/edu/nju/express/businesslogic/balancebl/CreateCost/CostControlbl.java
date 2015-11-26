package edu.nju.express.businesslogic.balancebl.CreateCost;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.businesslogic.balancebl.CostList.Info.CostControlInfo;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.*;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.Balancepo;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.BankingAccountVO;



public class CostControlbl implements CostControlService,CostControlInfo{

	

	
	
	balancedataservice balancedataservice;
	
	BankingInfo account;
	

	
	
	public CostControlbl(BankingInfo account) {
		// TODO Auto-generated constructor stub
	
	balancedataservice = RMIHelper.getBalanceDataService();
	
	this.account = account;
	

	
	
	
	}
	
	
	
	
	@Override
	public ResultMessage createCost(Balancevo vo) {
		// TODO Auto-generated method stub
		

		
		boolean exsit = false;
		
		ArrayList<BankingAccountVO> accounts = account.getAllAccounts();
		
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getName().equals(vo.getBanking())){
				exsit = true;
				break;
			}
			
		}
		
		
		if(exsit){
		modify(vo.getBanking(), (int)vo.getMoney());
		
		try {
			balancedataservice.insert(convertVO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ResultMessage.VALID;
		
		
		}else {
			return ResultMessage.INVALID;
		}
	}

	
	


	
	
	
	@Override
	public void endCostControl() {
		// TODO Auto-generated method stub
		
	}

	

	
	
	public Balancepo convertVO(Balancevo vo){
		return new Balancepo(vo.getDate(), vo.getMoney(), 
				                      vo.getName(), vo.getBanking(),
				                      vo.getItem(), vo.getRemark());
	}
	
	
	
	public Balancevo convertPO(Balancepo po){
		return new Balancevo(po.getDate(), po.getMoney(), 
				                      po.getName(), po.getBanking(),
				                      po.getItem(), po.getRemark());
	}
	
	
	
	public void modify(String name,int cost){
		account.modify(cost, name);
	}




	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		ArrayList<Balancevo> temps=new ArrayList<>();
		
		try {
			ArrayList<Balancepo> balancepos = balancedataservice.getAll();
		
		
			for(int i=0;i<balancepos.size();i++)
				temps.add(convertPO(balancepos.get(i)));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temps;
	}
	
}
