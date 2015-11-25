package edu.nju.express.data.vehicledata;


import java.util.ArrayList;

import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;




public interface VehicleDao {


	
	public void insertDri(Driverpo po) ;
	public void deleteDri(String id) ;
	public void updateDri(String number ,Driverpo po) ;
	public Driverpo findDri(String id) ;
	

	public ArrayList<Driverpo> getAllDrivers();
	
	public ArrayList<Driverpo> showAllDrivers();
	
	public void flushDrivers();
}
