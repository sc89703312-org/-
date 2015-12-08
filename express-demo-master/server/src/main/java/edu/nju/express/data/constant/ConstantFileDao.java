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
				double price = 23;
				double vanCost = 2;
				double railwayCost = 0.2;
				double airplaneCost = 20;
				int vanLoad =10;
				int railwayLoad = 2000;
				int airplaneLoad = 50;
				
				cityList.add("北京");
				cityList.add("上海");
				cityList.add("广州");
				cityList.add("南京");
				
				cityDistance.add("0 1064.7 1888.8 900");
				cityDistance.add("1064.7 0 1213 266");
				cityDistance.add("188.8 1213 0 1132");
				cityDistance.add("900 266 1132 0");
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
		return constantPO.getCityDistance();
	}





	@Override
	public void addCity(String CityID) {
		// TODO Auto-generated method stub
		ArrayList<String> cityList = constantPO.getCityList();
		int num = cityList.size();
		cityList.add(CityID);
		constantPO.setCityList(cityList);
		String last="";
		ArrayList<String> cityDistanceList = new ArrayList<>();
		for(int i=0;i<num;i++){
			cityDistanceList.add(constantPO.getCityDistance().get(i)+" 0");
			last+="0 ";
		}
		last+="0";
		cityDistanceList.add(last);
		constantPO.setCityDistance(cityDistanceList);
	}





	@Override
	public void setCityDistance(String CityID1, String CityID2, double distance) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> cityList = constantPO.getCityList();
		
		int city_1 = 0 , city_2 =0;
		
		
		
		for(int i=0;i<cityList.size();i++){			
			if (cityList.get(i).equals(CityID1)) {
				break;
			}
			city_1++;
		}
		
		for(int i=0;i<cityList.size();i++){			
			if (cityList.get(i).equals(CityID2)) {
				break;
			}
			city_2++;
		}
		
		
		String[] temp1=constantPO.getCityDistance().get(city_1).split(" ");
		String temp ="";
		for(int i=0;i<temp1.length;i++){
			if(i!=city_2)
				temp+=temp1[i];
			else 
				temp+=distance+"";
			
			
			if(i!=temp1.length-1)
				temp+=" ";
				
			
		}
		
		
		
		String[] temp2=constantPO.getCityDistance().get(city_2).split(" ");
		String temp3 ="";
		for(int i=0;i<temp2.length;i++){
			if(i!=city_1)
				temp3+=temp2[i];
			else 
				temp3+=distance+"";
			
			
			if(i!=temp2.length-1)
				temp3+=" ";
				
			
		}
	
		

		
		
		ArrayList<String> cityDistance = new ArrayList<>();
		
		for(int i=0;i<constantPO.getCityDistance().size();i++){
			
			if(i==city_1)
				cityDistance.add(temp);
			else if (i==city_2) {
				cityDistance.add(temp3);
			}else {
				cityDistance.add(constantPO.getCityDistance().get(i));
			}
		}
		
		
		
		
		
		
		System.out.println(cityDistance.get(city_1));
		System.out.println(cityDistance.get(city_2));
		
	
		constantPO.setCityDistance(cityDistance);
		
	}
}
