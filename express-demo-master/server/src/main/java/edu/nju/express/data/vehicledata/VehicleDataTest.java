package edu.nju.express.data.vehicledata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Driverpo;

public class VehicleDataTest extends CommonData<Driverpo> implements VehicleDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleDataTest(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}








	@Override
	public ResultMessage insertDri(Driverpo po) {
		// TODO Auto-generated method stub
		return inList.insert(po);
	}

	@Override
	public ResultMessage deleteDri(String id) {
		// TODO Auto-generated method stub
		return inList.delete(id);
	}

	@Override
	public ResultMessage updateDri(String number, Driverpo po) {
		// TODO Auto-generated method stub
		return inList.update(number, po);
	}

	@Override
	public Driverpo findDri(String id) {
		// TODO Auto-generated method stub
		return inList.find(id);
	}



	@Override
	public ArrayList<Driverpo> getAllDrivers() {
		// TODO Auto-generated method stub
		return inList.getAll();
	}


	@Override
	public void flushDrivers() {
		// TODO Auto-generated method stub
		 inList.flush();
	}








	@Override
	public ArrayList<Driverpo> showAllDrivers() {
		// TODO Auto-generated method stub
		return inList.showAll();
	}

	
}
