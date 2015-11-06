package client.dataservice.vehicledataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;


public interface vehicledataservice extends Remote {

	
	
	public void insertCar(Carpo po) throws RemoteException;
	public void deleteCar(int id) throws RemoteException;
	public void updateCar(int number,Carpo po) throws RemoteException;
	public Carpo findCar(int id) throws RemoteException;
	
	public void insertDri(Driverpo po) throws RemoteException;
	public void deleteDri(int id) throws RemoteException;
	public void updateDri(int number ,Driverpo po) throws RemoteException;
	public Driverpo findDri(int id) throws RemoteException;
	
	public void flushCars() throws RemoteException;
	
	public void flushDrivers() throws RemoteException;
	
}
