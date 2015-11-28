package edu.nju.express.po;

import java.io.Serializable;

import edu.nju.express.common.Item;




public class Balancepo extends ReceiptPOBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	double money;
	String name;
	String banking;
	Item item;
	String remark;

	
	public Balancepo(String date,double money,String name,
			               String banking,Item item,String remark) {
		// TODO Auto-generated constructor stub
	
	this.date = date;
	this.money = money;
	this.name = name;
	this.banking = banking;
	this.item = item;
	this.remark = remark;
	
	
	id= "Cost"+date+money+name+remark;
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
}
