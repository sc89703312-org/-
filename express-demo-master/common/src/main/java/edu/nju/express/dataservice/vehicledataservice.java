package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;




public interface vehicledataservice extends Remote {

	
	
	public void insertCar(Carpo po) throws RemoteException;
	public void deleteCar(String id) throws RemoteException;
	public void updateCar(String number,Carpo po) throws RemoteException;
	public Carpo findCar(String id) throws RemoteException;
	
	public void insertDri(Driverpo po) throws RemoteException;
	public void deleteDri(String id) throws RemoteException;
	public void updateDri(String number ,Driverpo po) throws RemoteException;
	public Driverpo findDri(String id) throws RemoteException;
	
	public void flushCars() throws RemoteException;
	
	public void flushDrivers() throws RemoteException;
	
}
