package edu.nju.express.vo;

public class SalaryVO  {

	
    private double clerkSalary;
	
	private double driverWage;
	
	private double postmanWage;
	
	
	
	public SalaryVO(double clerkSalary,
			        double driverWage,
			        double postmanWage) {
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
}
