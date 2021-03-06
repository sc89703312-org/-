package edu.nju.express.po;

import java.io.Serializable;

/**
 * 薪水的持久化对象
 * @author Dora
 * @version 2015-12-9 22:30:06
 */
public class SalaryPO extends PersistentObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9132465046645093029L;

	private double clerkSalary;
	
	private double driverWage;
	
	private double postmanWage;

	/**
	 * 
	 * @param clerkSalary 业务员月薪
	 * @param driverWage 司机提成
	 * @param postmanWage 快递员提成
	 */
	public SalaryPO(double clerkSalary ,double driverWage,double  postmanWage) {
		// TODO Auto-generated constructor stub
	
	
		this.clerkSalary = clerkSalary;
		this.driverWage = driverWage;
		this.postmanWage = postmanWage;
	}
	
	
	
	public double getClerkSalary() {
		return clerkSalary;
	}

	public double getDriverWage() {
		return driverWage;
	}

	public double getPostmanWage() {
		return postmanWage;
	}

	public void setClerkSalary(double clerkSalary) {
		this.clerkSalary = clerkSalary;
	}

	public void setDriverWage(double driverWage) {
		this.driverWage = driverWage;
	}

	public void setPostmanWage(double postmanWage) {
		this.postmanWage = postmanWage;
	}
	
	
}
