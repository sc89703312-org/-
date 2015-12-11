package edu.nju.express.vo;

import edu.nju.express.common.Item;




public class Balancevo extends ReceiptVOBase{
	String date;
	double money;
	String name;
	String banking;
	Item item;
	String remark;
	String id;
	
	public Balancevo(String date,double money,String name,
			               String banking,Item item,String remark,String id) {
		// TODO Auto-generated constructor stub
	
	this.date = date;
	this.money = money;
	this.name = name;
	this.banking = banking;
	this.item = item;
	this.remark = remark;
	
	
	this.id=id;
	}
	
	

	
	public String getDate(){
		return date;
	}
	public double getMoney(){
		return money;
	}
	
	public String getName(){
		return name;
	}
	
	public String getBanking(){
		return banking;
	}
	
	public Item getItem(){
		return item;
	}
	
	public String getRemark(){
		return remark;
	}
	
	
	public String toString(){
		return "Date: "+date+"   Money:"+money+"    Name:"
	                +name+"     Bank_Account:"+banking+"       +Item:"+
				    item+"     Remark:"+remark;
	}
	
	@Override
	public String getId(){
		return this.id;
	}
}
