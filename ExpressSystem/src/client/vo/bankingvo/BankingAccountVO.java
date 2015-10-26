package client.vo.bankingvo;

public class BankingAccountVO {

	int money;
	String name;
	
	public BankingAccountVO(String name){
		this.name = name;
		this.money = 0;
	}
	
	public BankingAccountVO(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addMoney(int num){
		money += num;
	}
	
	public void minusMoney(int num){
		money -= num;
	}
	
	public void changeName(String newName){
		name = newName;
	}
}
