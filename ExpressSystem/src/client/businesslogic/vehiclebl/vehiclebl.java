package client.businesslogic.vehiclebl;

import client.ResultMessage;
import client.blservice.vehicleblservice.Vehicleblservice;
import client.dataservice.vehicledataservice.vehicledataservice;
import client.main.RMIHelper;
import client.vo.drivervo.Drivervo;


public class vehiclebl implements Vehicleblservice{

	vehicledataservice vehicledataservice ;
	
	
	public vehiclebl() {
		// TODO Auto-generated constructor stub
	vehicledataservice = RMIHelper.getVehicleDataService();
	}
	
	
	@Override
	public ResultMessage addDriver(Drivervo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyDriver(int id, Drivervo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drivervo viewDriver(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endVehicle() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
