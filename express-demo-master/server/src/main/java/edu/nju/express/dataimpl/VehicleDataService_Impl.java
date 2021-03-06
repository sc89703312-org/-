package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.vehicledata.CarDao;
import edu.nju.express.data.vehicledata.CarDataTest;
import edu.nju.express.data.vehicledata.VehicleDao;
import edu.nju.express.data.vehicledata.VehicleDataTest;
import edu.nju.express.dataservice.vehicledataservice;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;



public class VehicleDataService_Impl extends UnicastRemoteObject  implements vehicledataservice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VehicleDao vehicleDao;
	CarDao carDao;
	
	
	public VehicleDataService_Impl() throws RemoteException{
		// TODO Auto-generated constructor stub

	vehicleDao = new VehicleDataTest("vehicle");
	carDao = new CarDataTest("car");
	}
	
	
	
	
	@Override
	public ResultMessage insertCar(Carpo po) throws RemoteException {
		// TODO Auto-generated method stub
	   return	carDao.insertCar(po);
		
	}

	@Override
	public ResultMessage deleteCar(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return carDao.deleteCar(id);
	}

	@Override
	public ResultMessage updateCar(String number, Carpo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to update");
		return carDao.updateCar(number, po);
	}

	@Override
	public Carpo findCar(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to find");
		return carDao.findCar(id);
	}

	@Override
	public ResultMessage insertDri(Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Prepares to insert a po");
		return vehicleDao.insertDri(po);
	}

	@Override
	public ResultMessage deleteDri(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to delete a po");
		return vehicleDao.deleteDri(id);
	}

	@Override
	public ResultMessage updateDri(String number, Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to update");
		return vehicleDao.updateDri(number, po);
	}

	@Override
	public Driverpo findDri(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to find");
		return vehicleDao.findDri(id);
	}




	@Override
	public void flushCars() {
		// TODO Auto-generated method stub
		carDao.flushCars();
	}




	@Override
	public void flushDrivers() {
		// TODO Auto-generated method stub
		vehicleDao.flushDrivers();
	}
	

	@Override
	public ArrayList<Carpo> getAllCars(){
		return carDao.showAllCars();
	}
	
	
	@Override
	public ArrayList<Driverpo> getAllDrivers(){
		return vehicleDao.showAllDrivers();
	}

}
