package server.data.vehicledata;


import java.util.ArrayList;

import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;


public interface VehicleDao {

	public void insertCar(Carpo po) ;
	public void deleteCar(int id) ;
	public void updateCar(int number,Carpo po) ;
	public Carpo findCar(int id) ;
	
	public void insertDri(Driverpo po) ;
	public void deleteDri(int id) ;
	public void updateDri(int number ,Driverpo po) ;
	public Driverpo findDri(int id) ;
	

	public ArrayList<Carpo> getAllCars();
	public ArrayList<Driverpo> getAllDrivers();
	
	
	public void flushCars();
	
	public void flushDrivers();
}
