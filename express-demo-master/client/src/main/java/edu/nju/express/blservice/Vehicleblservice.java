package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Drivervo;



public interface Vehicleblservice {

	
	public ResultMessage addDriver(Drivervo vo);
	public ResultMessage deleteDriver(String id);
	public ResultMessage modifyDriver(String id,Drivervo vo);
	public Drivervo viewDriver(String id);
	
	public void endVehicle();
}
