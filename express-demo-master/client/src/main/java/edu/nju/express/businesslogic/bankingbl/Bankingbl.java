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
		
		try {
			bankingDataService.addAccount(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultMessage removeAccount(String name) {
		// TODO Auto-generated method stub
		ResultMessage result = ResultMessage.INVALID;
		
		try {
			result = bankingDataService.removeAccount(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public ResultMessage modifyAccount(String newName, String name) {
		// TODO Auto-generated method stub
		
		ResultMessage result = ResultMessage.INVALID;
		
		try {
			result = bankingDataService.modifyName(newName, name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<BankingAccountVO> showAccount(String subName) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<BankingAccountPO> poList = bankingDataService.getAccount();
			ArrayList<BankingAccountVO> voList = new ArrayList<BankingAccountVO>();
			for(int i=0;i<poList.size();i++)
				voList.add(new BankingAccountVO(poList.get(i).getName(),poList.get(i).getMoney()));
			return voList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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