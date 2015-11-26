package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.express.data.salarydata.SalaryDao;
import edu.nju.express.data.salarydata.SalaryFileDao;
import edu.nju.express.dataservice.SalaryDataService;

public class SalaryDataService_Impl extends UnicastRemoteObject implements SalaryDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	SalaryDao salaryDao;
	

	public SalaryDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		salaryDao = new SalaryFileDao("salary");
	}

	@Override
	public void setClerkSalary(double salary) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDao.setClerkSalary(salary);
	}

	@Override
	public void setDriverWage(double wage) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDao.setDriverWage(wage);
	}

	@Override
	public void setPostmanWage(double wage) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDao.setPostmanWage(wage);
	}

	@Override
	public double getClerkSalary() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDao.getClerkSalary();
	}

	@Override
	public double getDriverWage() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDao.getDriverWage();
	}

	@Override
	public double getPostmanWage() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDao.getPostmanWage();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		salaryDao.flush();
	}

}
