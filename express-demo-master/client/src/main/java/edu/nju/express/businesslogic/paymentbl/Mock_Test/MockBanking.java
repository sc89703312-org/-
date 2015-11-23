package edu.nju.express.businesslogic.paymentbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.vo.BankingAccountVO;


/*
public class MockBanking implements BankingInfo {

	ArrayList<BankingAccountVO> accounts = new ArrayList<BankingAccountVO>();
	
	
	String[] accountNames =new String[3];
	
	int[] money =new int[3];
	
	
	public MockBanking() {
		// TODO Auto-generated constructor stub
	
		accountNames[0]="sc";
		money[0]=100000;
		
		accountNames[1]="a";
		money[1]=100000;
		
		accountNames[2]="hehe";
		money[2]=100000;
		
		accounts.add(new BankingAccountVO("sc"));
		accounts.add(new BankingAccountVO("a"));
		accounts.add(new BankingAccountVO("hehe"));
		
	}
	
	
	public void modify(int modify,String name){
		
		
		for(int i=0;i<3;i++){
			if(name.equals(accountNames[i])){
				money[i]+=modify;
				System.out.println("The banking of:"+accountNames[i]+" has changed");
			    break;
			}
				
		}
		
	}	
	
	
		
		public int getMoney(String name){
			
			
			for(int i=0;i<3;i++){
				if(name.equals(accountNames[i])){
					
					return money[i];
				
				}
					
			}
			return 0;
		}
		
		
		public ArrayList<BankingAccountVO> getAllAccounts(){
			return accounts;
		}
	
}
*/