package edu.nju.express.po;

import java.io.Serializable;


public class Carpo extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** 发动机类型 */
	String motor;
	
	/**车牌号*/
	String car;
	
	/**底盘号*/
	String base;
	
	/**购买时间*/
	String purchase;
	
	/**使用年限*/
	int use;
	
	public Carpo(String id,String motor,String car,String base,String purchase,int use) {
		// TODO Auto-generated constructor stub
	this.id = id;
	this.motor = motor;
	this.car = car;
	this.base = base;
	this.purchase = purchase;
	this.use = use;
	this.date = "";
	}
	
	
	

	
	public String getMotor(){
		return motor;
	}
	
	
	public String getCar(){
		return car;
	}
	
	public String getBase(){
		return base;
	}
	
	public String getPurchase(){
		return purchase;
	}
	
	
	public int getUse(){
		return  use;
	}
	
	
}
