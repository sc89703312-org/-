package client.blservice.vehicleblservice;

import client.ResultMessage;
import client.vo.carvo.Carvo;
import client.vo.drivervo.Drivervo;

public interface CarControlService {

	public ResultMessage addCar(Carvo vo);
	public ResultMessage deleteCar(int id);
	public ResultMessage modifyCar(int id,Carvo vo);
	public Carvo viewCar(int id);
	
	public void endCar();
	
}
