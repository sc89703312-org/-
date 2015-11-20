package edu.nju.express.data.vehicledata;


import java.util.ArrayList;

import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;




public interface VehicleDao {

	public void insertCar(Carpo po) ;
	public void deleteCar(String id) ;
	public void updateCar(String number,Carpo po) ;
	public Carpo findCar(String id) ;
	
	public void insertDri(Driverpo po) ;
	public void deleteDri(String id) ;
	public void updateDri(String number ,Driverpo po) ;
	public Driverpo findDri(String id) ;
	

	public ArrayList<Carpo> getAllCars();
	public ArrayList<Driverpo> getAllDrivers();
	
	
	public void flushCars();
	
	public void flushDrivers();
}
