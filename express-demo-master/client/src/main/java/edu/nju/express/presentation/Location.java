package edu.nju.express.presentation;

import java.util.ArrayList;

public class Location {
	public static ArrayList<String> NanjingHall_id = new ArrayList<String>();
	public static ArrayList<String> BeijingHall_id = new ArrayList<String>();
	public static ArrayList<String> ShanghaiHall_id = new ArrayList<String>();
	public static ArrayList<String> GuangzhouHall_id = new ArrayList<String>();
	
	public static ArrayList<String> NanjingHall = new ArrayList<String>();
	public static ArrayList<String> BeijingHall = new ArrayList<String>();
	public static ArrayList<String> ShanghaiHall = new ArrayList<String>();
	public static ArrayList<String> GuangzhouHall = new ArrayList<String>();
	
	public static ArrayList<String> station_id = new ArrayList<String>();
	public static ArrayList<String> station = new ArrayList<String>();
	
	public Location(){
		
		
	}
	
	public static void init(){
		NanjingHall_id.add("025001");
		NanjingHall_id.add("025002");
		NanjingHall_id.add("025003");
		NanjingHall_id.add("025004");
		
		BeijingHall_id.add("010001");
		BeijingHall_id.add("010002");
		BeijingHall_id.add("010003");
		BeijingHall_id.add("010004");
		
		ShanghaiHall_id.add("021001");
		ShanghaiHall_id.add("021002");
		ShanghaiHall_id.add("021003");
		ShanghaiHall_id.add("021004");
		
		GuangzhouHall_id.add("020001");
		GuangzhouHall_id.add("020002");
		GuangzhouHall_id.add("020003");
		GuangzhouHall_id.add("020004");
		
		NanjingHall.add("南京栖霞区营业厅");
		NanjingHall.add("南京浦口区营业厅");
		NanjingHall.add("南京鼓楼区营业厅");
		NanjingHall.add("南京玄武区营业厅");
		
		BeijingHall.add("北京东城区营业厅");
		BeijingHall.add("北京西城区营业厅");
		BeijingHall.add("北京海淀区营业厅");
		BeijingHall.add("北京朝阳区营业厅");
		
		ShanghaiHall.add("上海徐汇区营业厅");
		ShanghaiHall.add("上海闵行区营业厅");
		ShanghaiHall.add("上海浦东区营业厅");
		ShanghaiHall.add("上海黄埔区营业厅");
		
		//Guangzhou
		
		station_id.add("025");
		station_id.add("010");
		station_id.add("021");
		station_id.add("020");
		
		station.add("南京");
		station.add("北京");
		station.add("上海");
		station.add("广州");
		
	}
	
	public static String getHallLocation(String id){
		String loca="";
		String city = id.substring(0, 3);
		switch(city){
		case "025": for(int i=0; i<NanjingHall_id.size(); i++){
			if(id.equals(NanjingHall_id.get(i))){
				loca = NanjingHall.get(i);
			}
		}
			break;
		case "010": for(int i=0; i<BeijingHall_id.size(); i++){
			if(id.equals(BeijingHall_id.get(i))){
				loca = BeijingHall.get(i);
			}
		}
			break;
		
		case "021": for(int i=0; i<ShanghaiHall_id.size(); i++){
			if(id.equals(ShanghaiHall_id.get(i))){
				loca = ShanghaiHall.get(i);
			}
		}
			break;
		
		default: for(int i=0; i<GuangzhouHall_id.size(); i++){
			if(id.equals(GuangzhouHall_id.get(i))){
				loca = GuangzhouHall.get(i);
			}
		}
			break;
		
		}
		return loca;
	}
	
	public static String getStationLocation(String id){
		for(int i=0; i<station.size(); i++){
			if(id.equals(station_id.get(i))){
				return station.get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<String> getHallList(String id){
		switch(id){
		case "025": return NanjingHall;
		case "010": return BeijingHall;
		case "021": return ShanghaiHall;
		default: return GuangzhouHall;
		}
	}
	
//	public static void main(String[] args){
//		System.out.println(Location.getStationLocation("021"));
//	}

	
}
