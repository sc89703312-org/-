package client.businesslogic.accountbl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.vehiclebl.CarControl;
import client.vo.carvo.Carvo;


public class MockVehicle extends CarControl{

	ArrayList<Carvo> cars = new ArrayList<Carvo>();
	
	
	public MockVehicle() {
		// TODO Auto-generated constructor stub
	
	
	cars.add(new Carvo(
			1, "Motor-1",
			"Su-A", "Base-1",
			"2011/1/1", 5));
	
	
	cars.add(new Carvo(
			2, "Motor-1",
			"Su-A", "Base-1",
			"2011/1/1", 5));
	
	
	
	cars.add(new Carvo(
			3, "Motor-1",
			"Su-A", "Base-1",
			"2011/1/1", 5));
	
	
	
	
	}
	
	
	@Override
	public ArrayList<Carvo> getAll(){
		return cars;
	}
	
	
	
	
}
