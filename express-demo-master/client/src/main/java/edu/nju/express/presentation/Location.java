package edu.nju.express.presentation;

public class Location {
	public static String[] NanjingHall_id = {"025001","025002","025003","025004"};
	public static String[] BeijingHall_id = {"010001","010002","010003","010004"};
	public static String[] ShanghaiHall_id = {"021001","021002","021003","021004"};
	public static String[] GuangzhouHall_id = {"020001","020002","020003","020004"};
	
	public static String[] NanjingHall = {"南京栖霞区营业厅","南京浦口营业厅","南京鼓楼区营业厅","南京玄武区营业厅"};
	public static String[] BeijingHall = {"北京东城区营业厅","北京西城区营业厅","北京海淀区营业厅","北京朝阳区营业厅"};
	public static String[] ShanghaiHall = {"上海徐汇区营业厅","上海闵行区营业厅","上海浦东区营业厅","上海黄埔区营业厅"};
	public static String[] GuangzhouHall = {};
	
	public static String[] station_id = {"025","010","021","020"};
	
	public static String[] station = {"南京","北京","上海","广州"};
	
	public static String getHallLocation(String id){
		String loca="";
		String city = id.substring(0, 3);
		switch(city){
		case "025": for(int i=0; i<NanjingHall_id.length; i++){
			if(id.equals(NanjingHall_id[i])){
				loca = NanjingHall[i];
			}
		}
			break;
		case "010": for(int i=0; i<BeijingHall_id.length; i++){
			if(id.equals(BeijingHall_id[i])){
				loca = BeijingHall[i];
			}
		}
			break;
		
		case "021": for(int i=0; i<ShanghaiHall_id.length; i++){
			if(id.equals(ShanghaiHall_id[i])){
				loca = ShanghaiHall[i];
			}
		}
			break;
		
		default: for(int i=0; i<GuangzhouHall_id.length; i++){
			if(id.equals(GuangzhouHall_id[i])){
				loca = GuangzhouHall[i];
			}
		}
			break;
		
		}
		return loca;
	}
	
	public static String getStationLocation(String id){
		for(int i=0; i<station.length; i++){
			if(id.equals(station_id[i])){
				return station[i];
			}
		}
		return null;
	}
	
//	public static void main(String[] args){
//		System.out.println(Location.getStationLocation("021"));
//	}

	
}
