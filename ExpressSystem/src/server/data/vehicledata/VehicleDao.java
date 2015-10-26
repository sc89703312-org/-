package server.data.vehicledata;


import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;


public interface VehicleDao {

	public void insertCar(Carpo po) ;
	public void deleteCar(Carpo po) ;
	public void updateCar(int number,Carpo po) ;
	public Carpo findCar(int id) ;
	
	public void insertDri(Driverpo po) ;
	public void deleteDri(Driverpo po) ;
	public void updateDri(int number ,Driverpo po) ;
	public Driverpo findDri(int id) ;
	
	
}
