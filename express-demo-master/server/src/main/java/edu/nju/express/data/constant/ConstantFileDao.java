package edu.nju.express.data.constant;

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

import edu.nju.express.po.ConstantPO;

public class ConstantFileDao implements ConstantDao {

	
	
	String path;
	ConstantPO constantPO;
	
	
	
	
	public ConstantFileDao(String file) {
		// TODO Auto-generated constructor stub
		path = "data/"+ file+".txt";
		constantPO = read();
	}
	
	
	
	
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		try {
			File f = new File(path);
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
	 
	
	 try {
		 
		
		 
			ObjectOutputStream os;
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(constantPO);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ConstantPO read(){
		ObjectInputStream is = null;

		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				
				
				ArrayList<String> cityList = new ArrayList<>();
				ArrayList<String> cityDistance = new ArrayList<>();
				double price = 20;
				double vanCost = 25;
				double railwayCost = 30;
				double airplaneCost = 50;
				int vanLoad =11;
				int railwayLoad = 15;
				int airplaneLoad = 20;
				
				cityList.add("NanJing");
				cityList.add("BeiJing");
				cityList.add("ShangHai");
				cityList.add("GuangZhou");
				
				cityDistance.add("0 1000 400 1000");
				cityDistance.add("1000 0 1200 2000");
				cityDistance.add("400 1200 0 1000");
				cityDistance.add("1000 2000 1000 0");
				return new ConstantPO(cityList, cityDistance, price, vanCost, railwayCost, airplaneCost, vanLoad, railwayLoad, airplaneLoad);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				
				ConstantPO temp = (ConstantPO) is.readObject();
				constantPO = temp;
			}
		} catch (Exception ex) {
			try {
				
				if(is!=null)
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return constantPO;
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		constantPO.setPrice(price);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return constantPO.getPrice();
	}

	@Override
	public void setVehicleCost(double van, double railway, double airplane) {
		// TODO Auto-generated method stub
		constantPO.setVanCost(van);
		constantPO.setRailwayCost(railway);
		constantPO.setAirplaneCost(airplane);
	}

	@Override
	public double[] getVehicleCost() {
		// TODO Auto-generated method stub
		
		
		double[] temp = {constantPO.getVanCost(),constantPO.getRailwayCost(),constantPO.getAirplaneCost()};
		
		return temp;
	}

	@Override
	public void setVehicleLoad(int van, int railway, int airplane) {
		// TODO Auto-generated method stub
		constantPO.setVanLoad(van);
		constantPO.setRailwayLoad(railway);
		constantPO.setAirplaneLoad(airplane);
	}

	@Override
	public int[] getVehicleLoad() {
		// TODO Auto-generated method stub
		
		int temp[] ={constantPO.getVanLoad(),constantPO.getRailwayLoad(),constantPO.getAirplaneLoad()};
		
		return temp;
	}

	
	
	public class MyObjectOutputStream extends ObjectOutputStream {
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
	public ArrayList<String> getCityList() {
		// TODO Auto-generated method stub
		return constantPO.getCityList();
	}

	@Override
	public ArrayList<String> getCityDistance() {
		// TODO Auto-generated method stub
		return constantPO.getCityList();
	}
}
