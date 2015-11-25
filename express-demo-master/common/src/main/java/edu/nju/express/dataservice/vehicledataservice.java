package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;




public interface vehicledataservice extends Remote {

	
	
	public ResultMessage insertCar(Carpo po) throws RemoteException;
	public ResultMessage deleteCar(String id) throws RemoteException;
	public ResultMessage updateCar(String number,Carpo po) throws RemoteException;
	public Carpo findCar(String id) throws RemoteException;
	
	public ResultMessage insertDri(Driverpo po) throws RemoteException;
	public ResultMessage deleteDri(String id) throws RemoteException;
	public ResultMessage updateDri(String number ,Driverpo po) throws RemoteException;
	public Driverpo findDri(String id) throws RemoteException;
	
	public void flushCars() throws RemoteException;
	
	public void flushDrivers() throws RemoteException;
	
	public ArrayList<Carpo> getAllCars() throws RemoteException;
	
	public ArrayList<Driverpo> getAllDrivers() throws RemoteException;
}
