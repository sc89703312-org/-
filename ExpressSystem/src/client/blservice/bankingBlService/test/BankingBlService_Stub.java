package client.blservice.bankingBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.bankingBlService.BankingBlService;
import client.vo.bankingvo.BankingAccountVO;

public class BankingBlService_Stub implements BankingBlService{

	public void addAccount(String name){
		
		System.out.println("add banking Account successfully!");
		
	}
	
	public ResultMessage removeAccount(String name){
		
		ResultMessage result;
		if(name=="SC"){
			result = ResultMessage.VALID;
			System.out.println("remove successfully!");
		}
		else
			result = ResultMessage.INVALID;
		
		return result;
		
	}
	
	public ResultMessage modifyAccount(String newName, String name){
		
		ResultMessage result;
		if(name=="SC"){
			result = ResultMessage.VALID;
			System.out.println("modify name successfully!");
		}
		else
			result = ResultMessage.INVALID;
		
		return result;
		
	}
	
	public ArrayList<BankingAccountVO> showAccount(String subName){
		
		ArrayList<BankingAccountVO> account_list = new ArrayList<BankingAccountVO>();
		account_list.add(new BankingAccountVO("SC" , 0));
		
		return account_list;
		
	}
	
}
