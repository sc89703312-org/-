package client.po.bankingpo;

import java.io.Serializable;

public class BankingAccountPO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	int money;
	
	public BankingAccountPO(String name){
		
		this.name = name;
		this.money = 0;
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void changeName(String newName){
		this.name = newName;
	}
	
	public void addMoney(int num){
		this.money = this.money + num;
	}
	
	public void minusMoney(int num){
		this.money = this.money - num;
	}
	
}
