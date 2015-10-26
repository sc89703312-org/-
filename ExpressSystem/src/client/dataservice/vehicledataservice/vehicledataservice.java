package client.dataservice.vehicledataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;


public interface vehicledataservice extends Remote {

	
	
	public void insertCar(Carpo po) throws RemoteException;
	public void deleteCar(Carpo po) throws RemoteException;
	public void updateCar(int number,Carpo po) throws RemoteException;
	public Carpo findCar(int id) throws RemoteException;
	
	public void insertDri(Driverpo po) throws RemoteException;
	public void deleteDri(Driverpo po) throws RemoteException;
	public void updateDri(int number ,Driverpo po) throws RemoteException;
	public Driverpo findDri(int id) throws RemoteException;
	
	
}
