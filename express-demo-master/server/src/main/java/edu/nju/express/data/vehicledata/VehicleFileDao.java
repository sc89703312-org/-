package edu.nju.express.data.vehicledata;

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

import edu.nju.express.po.Carpo;
import edu.nju.express.po.Driverpo;



public class VehicleFileDao  {
/*
	ArrayList<Carpo> cars  = new ArrayList<Carpo>();
	ArrayList<Driverpo> drivers = new ArrayList<Driverpo>();
	
	
	public VehicleFileDao() {
		// TODO Auto-generated constructor stub
	
	cars = getAllCars();
	drivers = getAllDrivers();

	}
	
	
	
	@Override
	public void insertCar(Carpo po) {
		// TODO Auto-generated method stub	
		cars.add(po);
	}

	
	@Override
	public void deleteCar(String id) {
		// TODO Auto-generated method stub

		System.out.println("Before delete " +cars.size());
		for(int i=0;i<cars.size();i++){
			
			if(cars.get(i).getId()==id){
				cars.remove(i);
				break;
		}
		}
	
		System.out.println("After delete "+cars.size());
	}

	@Override
	public void updateCar(String number, Carpo po) {
		// TODO Auto-generated method stub
		   
		deleteCar(number);
		insertCar(po);
	}

	
	
	@Override
	public Carpo findCar(String id) {
		// TODO Auto-generated method stub

		
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
	}

	
	
	@Override
	public void deleteDri(String id) {
		// TODO Auto-generated method stub
		
		   
		   System.out.println("Before delete " +drivers.size());
			for(int i=0;i<drivers.size();i++){				
				if(drivers.get(i).getId()==id){
					drivers.remove(i);
					break;
			}
			}
		
			System.out.println("After delete "+drivers.size());
			
	     
	}

	@Override
	public void updateDri(String number, Driverpo po) {
		// TODO Auto-generated method stub
		deleteDri(number);
		insertDri(po);
	}

	@Override
	public Driverpo findDri(String id) {
		// TODO Auto-generated method stub
 
		
		for(int i=0;i<drivers.size();i++){
			
			if(drivers.get(i).getId()==id){
				System.out.println("Find");
				return drivers.get(i);
		}
		}
		System.out.println("Miss");
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
				if(is!=null)
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
		drivers.clear();
		ObjectInputStream is = null;
		File file = new File("driver.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return drivers;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Driverpo temp = (Driverpo) is.readObject();
				drivers.add(temp);
			}
		} catch (Exception ex) {
			try {
				if(is!=null)
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return drivers;
	}



	@Override
	public void flushCars() {
		// TODO Auto-generated method stub
		
		 try {
				File f = new File("vehicle.txt");
				FileWriter fw =  new FileWriter(f);
				fw.write("");
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
		
		for(int i=0;i<cars.size();i++){
			try {
				
				
				Carpo po = cars.get(i);
				
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
		
	}



	@Override
	public void flushDrivers() {
		// TODO Auto-generated method stub
		
		 try {
				File f = new File("driver.txt");
				FileWriter fw =  new FileWriter(f);
				fw.write("");
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		 for(int i=0;i<drivers.size();i++){
			 Driverpo po = drivers.get(i);

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
		
		
	}*/
}
