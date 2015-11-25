package edu.nju.express.data.vehicledata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Carpo;

public interface CarDao {

	
	public ResultMessage insertCar(Carpo po) ;
	public ResultMessage deleteCar(String id) ;
	public ResultMessage updateCar(String number,Carpo po) ;
	public Carpo findCar(String id) ;
	
	

	public ArrayList<Carpo> getAllCars();
	
	public ArrayList<Carpo> showAllCars();
	

	public void flushCars();
}
