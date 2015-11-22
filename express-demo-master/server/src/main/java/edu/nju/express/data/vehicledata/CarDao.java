package edu.nju.express.data.vehicledata;

import java.util.ArrayList;

import edu.nju.express.po.Carpo;

public interface CarDao {

	
	public void insertCar(Carpo po) ;
	public void deleteCar(String id) ;
	public void updateCar(String number,Carpo po) ;
	public Carpo findCar(String id) ;
	
	

	public ArrayList<Carpo> getAllCars();
	
	

	public void flushCars();
}
