package edu.nju.express.businesslogic.vehiclebl;

import edu.nju.express.blservice.Vehicleblservice;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Drivervo;


/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:57:02
 * 
 * 营业厅业务员进行司机管理
 */
public class DriverController implements Vehicleblservice {

	
	private Vehicleblservice driver ;
	
	public DriverController() {
		// TODO Auto-generated constructor stub
	
	
	driver = DataFactory.createDriverInstance();
	}
	
	@Override
	public ResultMessage addDriver(Drivervo vo) {
		// TODO Auto-generated method stub
		return driver.addDriver(vo);
	}

	@Override
	public ResultMessage deleteDriver(String id) {
		// TODO Auto-generated method stub
		return driver.deleteDriver(id);
	}

	@Override
	public ResultMessage modifyDriver(String id, Drivervo vo) {
		// TODO Auto-generated method stub
		return driver.modifyDriver(id, vo);
	}

	@Override
	public Drivervo viewDriver(String id) {
		// TODO Auto-generated method stub
		return driver.viewDriver(id);
	}

	@Override
	public void endVehicle() {
		// TODO Auto-generated method stub
		
	}

}
