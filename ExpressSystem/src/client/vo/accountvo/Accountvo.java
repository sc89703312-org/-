package client.vo.accountvo;

import java.util.ArrayList;

import client.vo.carvo.Carvo;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;
import client.vo.uservo.UserVO;


public class Accountvo {
	ArrayList<HallVO> hall_list = new ArrayList<HallVO>();
	ArrayList<StationVO> station_list  = new ArrayList<StationVO>();
	ArrayList<UserVO> user_list = new ArrayList<UserVO>();
	ArrayList<Carvo> car_list = new ArrayList<Carvo>();
	
	
	
	
	
	public Accountvo(ArrayList<HallVO> hall_list,
			                ArrayList<StationVO> station_list,
			                ArrayList<UserVO> user_list,
			                ArrayList<Carvo> car_list ) {
		// TODO Auto-generated constructor stub

	
	this.hall_list = hall_list;
	this.station_list = station_list;
	this.user_list = user_list;
	this.car_list = car_list;
	
	}
	
	public ArrayList<HallVO> getHallList(){
		return hall_list;
	}
	
	public ArrayList<StationVO> getStationList(){
		return station_list;
	}
	public ArrayList<UserVO> getUserList(){
		return user_list;
	}
	public ArrayList<Carvo> getCarList(){
		return car_list;
	}
}
