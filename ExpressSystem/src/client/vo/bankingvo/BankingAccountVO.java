package client.vo.bankingvo;

public class BankingAccountVO {

	int money;
	String name;
	
	public int getMoney(){
		return this.money;
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
