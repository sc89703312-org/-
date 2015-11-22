package edu.nju.express.po;

import java.io.Serializable;


public class Carpo extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	String motor;
	String car;
	String base;
	String purchase;
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
