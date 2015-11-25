package edu.nju.express.data.vehicledata;


import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;




public interface VehicleDao {


	
	public ResultMessage insertDri(Driverpo po) ;
	public ResultMessage deleteDri(String id) ;
	public ResultMessage updateDri(String number ,Driverpo po) ;
	public Driverpo findDri(String id) ;
	

	public ArrayList<Driverpo> getAllDrivers();
	
	public ArrayList<Driverpo> showAllDrivers();
	
	public void flushDrivers();
}
