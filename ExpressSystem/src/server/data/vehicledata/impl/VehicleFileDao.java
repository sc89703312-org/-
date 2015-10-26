package server.data.vehicledata.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;
import server.data.vehicledata.VehicleDao;

public class VehicleFileDao implements VehicleDao {

	ArrayList<Carpo> cars ;
	ArrayList<Driverpo> drivers;
	
	
	public VehicleFileDao() {
		// TODO Auto-generated constructor stub
	
	cars = new ArrayList<Carpo>();
	drivers = new ArrayList<Driverpo>();
	
	
	
	}
	
	
	
	@Override
	public void insertCar(Carpo po) {
		// TODO Auto-generated method stub
		
		cars.add(po);
		
		
		try {
			ObjectOutputStream os;
			File file = new File("vehicle.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(po);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCar(Carpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCar(int number, Carpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carpo findCar(int id) {
		// TODO Auto-generated method stub
		
		
		
		for(int i=0;i<cars.size();i++){
			if(cars.get(i).getId()==id)
				return cars.get(i);
		}
		
		return null;
	}

	@Override
	public void insertDri(Driverpo po) {
		// TODO Auto-generated method stub
		
	drivers.add(po);
		
		
		try {
			ObjectOutputStream os;
			File file = new File("vehicle.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(po);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteDri(Driverpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDri(int number, Driverpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Driverpo findDri(int id) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<drivers.size();i++){
			if(drivers.get(i).getId()==id)
				return drivers.get(i);
		}
		
		return null;
	}

	
	
	class MyObjectOutputStream extends ObjectOutputStream {
		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		protected void writeStreamHeader() throws IOException {
			return;
		}
}
}
