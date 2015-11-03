package server.data.vehicledata.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;
import client.po.paymentpo.Paymentpo;
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
		
//		cars.add(po);
		
		
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
	public void deleteCar(int id) {
		// TODO Auto-generated method stub
	   getAllCars();
		
	   
	   System.out.println("Before delete " +cars.size());
		for(int i=0;i<cars.size();i++){
			
			if(cars.get(i).getId()==id){
				cars.remove(i);
				break;
		}
		}
	
		System.out.println("After delete "+cars.size());
		
      try {
		File f = new File("vehicle.txt");
		FileWriter fw =  new FileWriter(f);
		fw.write("");
		fw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
      for(int q=0;q<cars.size();q++){
    	  insertCar(cars.get(q));
      }
	
	}

	@Override
	public void updateCar(int number, Carpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carpo findCar(int id) {
		// TODO Auto-generated method stub
		getAllCars();
		
		for(int i=0;i<cars.size();i++){
			
			if(cars.get(i).getId()==id){
				System.out.println("Find");
				return cars.get(i);
		}
		}
		System.out.println("Miss");
		return null;
	}

	
	
	
	
	
	@Override
	public void insertDri(Driverpo po) {
		// TODO Auto-generated method stub
		
	drivers.add(po);
		
		
		try {
			ObjectOutputStream os;
			File file = new File("driver.txt");
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
			if(drivers.get(i).getId()==id){
				System.out.println("find it !");
				return drivers.get(i);
		}
		}
		System.out.println("Can't find");
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



	@Override
	public ArrayList<Carpo> getAllCars() {
		// TODO Auto-generated method stub
		cars.clear();
		ObjectInputStream is = null;
		File file = new File("vehicle.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return cars;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Carpo temp = (Carpo) is.readObject();
				cars.add(temp);
			}
		} catch (Exception ex) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return cars;
		
		
		
	}



	@Override
	public ArrayList<Driverpo> getAllDrivers() {
		// TODO Auto-generated method stub
		return null;
	}
}
