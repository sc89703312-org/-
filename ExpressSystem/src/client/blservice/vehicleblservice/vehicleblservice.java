package client.blservice.vehicleblservice;

import client.ResultMessage;
import client.vo.drivervo.Drivervo;


public interface Vehicleblservice {

	
	public ResultMessage addDriver(Drivervo vo);
	public ResultMessage deleteDriver(int id);
	public ResultMessage modifyDriver(int id,Drivervo vo);
	public Drivervo viewDriver(int id);
	
	public void endVehicle();
}
