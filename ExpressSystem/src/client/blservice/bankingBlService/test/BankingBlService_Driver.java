package client.blservice.bankingBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.bankingBlService.BankingBlService;
import client.vo.bankingvo.BankingAccountVO;

public class BankingBlService_Driver {

	public void drive(BankingBlService service){
		
		service.addAccount("SC");
		
		ResultMessage result;
		
		result = service.modifyAccount("STAR", "SC");
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
		
		result = service.removeAccount("STAR");
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
		ArrayList<BankingAccountVO> account_list = service.showAccount("S");
		BankingAccountVO bankingAccount = account_list.get(0);
		System.out.println("accountName: "+bankingAccount.getName()+" accountMoney: "+bankingAccount.getMoney());
		
	}
	
	public static void main(String[] args){
		BankingBlService_Driver driver = new BankingBlService_Driver();
		driver.drive(new BankingBlService_Stub());
	}
	
}
