package edu.nju.express.businesslogic.hallbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.vo.Carvo;



public class MockVehicle extends Vehiclebl{
	ArrayList<Carvo> carList;
	
	public MockVehicle(){
		carList = new ArrayList<Carvo>();
		carList.add(new Carvo(
				1, "Motor-1",
				"Su-A", "Base-1",
				"2011/1/1", 5));
		
		
		carList.add(new Carvo(
				2, "Motor-1",
				"Su-A", "Base-1",
				"2011/1/1", 5));
		
		
		
		carList.add(new Carvo(
				3, "Motor-1",
				"Su-A", "Base-1",
				"2011/1/1", 5));
		
	}
	
	
	
	public Carvo viewCar(String id){
		for(Carvo cari : carList){
			if(id.equals(cari.getId())){
				return cari;
			}
		}
		return null;
	}
}
