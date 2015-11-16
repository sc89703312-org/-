package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Drivervo;



public interface Vehicleblservice {

	
	public ResultMessage addDriver(Drivervo vo);
	public ResultMessage deleteDriver(int id);
	public ResultMessage modifyDriver(int id,Drivervo vo);
	public Drivervo viewDriver(int id);
	
	public void endVehicle();
}
