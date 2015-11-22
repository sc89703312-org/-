package edu.nju.express.data.vehicledata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
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
	public void insertCar(Carpo po) {
		// TODO Auto-generated method stub
		inList.insert(po);
	}

	@Override
	public void deleteCar(String id) {
		// TODO Auto-generated method stub
		inList.delete(id);
	}

	@Override
	public void updateCar(String number, Carpo po) {
		// TODO Auto-generated method stub
		
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

}
