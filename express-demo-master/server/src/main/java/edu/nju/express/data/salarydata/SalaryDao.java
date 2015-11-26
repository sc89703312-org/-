package edu.nju.express.data.salarydata;

import edu.nju.express.po.SalaryPO;



public interface SalaryDao {

	

	
    public void setClerkSalary(double salary) ;
	
	public void setDriverWage(double wage) ;
	
	public void setPostmanWage(double wage) ;
	
	public double getClerkSalary();
	
	public double getDriverWage();
	
	public double getPostmanWage() ;
	
	public SalaryPO read();
	
	public void flush();
}
