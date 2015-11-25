package edu.nju.express.data.vehicledata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Carpo;

public class CarDataTest extends CommonData<Carpo> implements CarDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarDataTest(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insertCar(Carpo po) {
		// TODO Auto-generated method stub
		return inList.insert(po);
	}

	@Override
	public ResultMessage deleteCar(String id) {
		// TODO Auto-generated method stub
		return inList.delete(id);
	}

	@Override
	public ResultMessage updateCar(String number, Carpo po) {
		// TODO Auto-generated method stub
		return update(number, po);
	}

	@Override
	public Carpo findCar(String id) {
		// TODO Auto-generated method stub
		return inList.find(id);
	}

	@Override
	public ArrayList<Carpo> getAllCars() {
		// TODO Auto-generated method stub
		return inList.getAll();
	}
	@Override
	public void flushCars() {
		// TODO Auto-generated method stub
		inList.flush();
	}

	@Override
	public ArrayList<Carpo> showAllCars() {
		// TODO Auto-generated method stub
		return inList.showAll();
	}

}
