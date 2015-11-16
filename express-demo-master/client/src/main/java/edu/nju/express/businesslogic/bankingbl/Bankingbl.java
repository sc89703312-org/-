package edu.nju.express.businesslogic.bankingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.BankingDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.BankingAccountPO;
import edu.nju.express.vo.BankingAccountVO;



public class Bankingbl implements BankingBlService{
	
	BankingDataService bankingDataService;
	
	public Bankingbl(){
		bankingDataService = RMIHelper.getBankingDataService();
	}

	@Override
	public void addAccount(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage removeAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyAccount(String newName, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankingAccountVO> showAccount(String subName) {
		// TODO Auto-generated method stub
		return null;
	}
	
    public void modify(int modify,String name) {
    		
    	try {
		    if(modify>=0)
				bankingDataService.income(name, modify);
			else
		    	bankingDataService.expend(name, -modify);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public int getMoney(String name){
			
		int result = -1;
		
		try {
			ArrayList<BankingAccountPO> accountList = bankingDataService.getAccount();
			for(int i=0;i<accountList.size();i++)
				if(accountList.get(i).getName().equals(name))
					result = accountList.get(i).getMoney();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

    }
	
}
