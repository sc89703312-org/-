package edu.nju.express.po;

import java.io.Serializable;

public class SalaryPO extends PersistentObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9132465046645093029L;

	private double clerkSalary;
	
	private double driverWage;
	
	private double postmanWage;

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
