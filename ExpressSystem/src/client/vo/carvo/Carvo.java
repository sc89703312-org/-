package client.vo.carvo;


public class Carvo {
	int id;
	String motor;
	String car;
	String base;
	String purchase;
	int use;
	
	public Carvo(int id,String motor,String car,String base,String purchase,int use) {
		// TODO Auto-generated constructor stub
	this.id = id;
	this.motor = motor;
	this.car = car;
	this.base = base;
	this.purchase = purchase;
	this.use = use;
	
	}
	
	
	
	public int getId(){
		return id;
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
