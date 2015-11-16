package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.express.data.vehicledata.VehicleDao;
import edu.nju.express.data.vehicledata.VehicleFileDao;
import edu.nju.express.dataservice.vehicledataservice;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;



public class VehicleDataService_Impl extends UnicastRemoteObject  implements vehicledataservice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VehicleDao vehicleDao;
	
	
	public VehicleDataService_Impl() throws RemoteException{
		// TODO Auto-generated constructor stub

	vehicleDao = new VehicleFileDao();
	}
	
	
	
	
	@Override
	public void insertCar(Carpo po) throws RemoteException {
		// TODO Auto-generated method stub
		vehicleDao.insertCar(po);
		System.out.println("Have inserted a po");
	}

	@Override
	public void deleteCar(int id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Prepares to delete a car");
		vehicleDao.deleteCar(id);
	}

	@Override
	public void updateCar(int number, Carpo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to update");
		vehicleDao.updateCar(number, po);
	}

	@Override
	public Carpo findCar(int id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to find");
		return vehicleDao.findCar(id);
	}

	@Override
	public void insertDri(Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("Prepares to insert a po");
		vehicleDao.insertDri(po);
	}

	@Override
	public void deleteDri(int id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to delete a po");
		vehicleDao.deleteDri(id);
	}

	@Override
	public void updateDri(int number, Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to update");
		vehicleDao.updateDri(number, po);
	}

	@Override
	public Driverpo findDri(int id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to find");
		return vehicleDao.findDri(id);
	}




	@Override
	public void flushCars() {
		// TODO Auto-generated method stub
		vehicleDao.flushCars();
	}




	@Override
	public void flushDrivers() {
		// TODO Auto-generated method stub
		vehicleDao.flushDrivers();
	}

}
