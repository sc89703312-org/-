package server.dataservice.vehicledataservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.data.vehicledata.VehicleDao;
import server.data.vehicledata.impl.VehicleFileDao;
import client.dataservice.vehicledataservice.vehicledataservice;
import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;

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
		
		
		vehicleDao.insertDri(po);
	}

	@Override
	public void deleteDri(Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDri(int number, Driverpo po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Driverpo findDri(int id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("prepares to find");
		return vehicleDao.findDri(id);
	}

}
