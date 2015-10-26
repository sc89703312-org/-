package client.po.accountpo;

import java.io.Serializable;
import java.util.ArrayList;

import client.po.HallPo.HallPo;
import client.po.carpo.Carpo;
import client.po.stationpo.StationPO;
import client.po.userpo.UserPO;


public class Accountpo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	ArrayList<HallPo> hall_list = new ArrayList<HallPo>();
	ArrayList<StationPO> station_list  = new ArrayList<StationPO>();
	ArrayList<UserPO> user_list = new ArrayList<UserPO>();
	ArrayList<Carpo> car_list = new ArrayList<Carpo>();
	
	
	
	
	
	public Accountpo(ArrayList<HallPo> hall_list,
			                ArrayList<StationPO> station_list,
			                ArrayList<UserPO> user_list,
			                ArrayList<Carpo> car_list ) {
		// TODO Auto-generated constructor stub

	
	this.hall_list = hall_list;
	this.station_list = station_list;
	this.user_list = user_list;
	this.car_list = car_list;
	
	}
	
	public ArrayList<HallPo> getHallList(){
		return hall_list;
	}
	
	public ArrayList<StationPO> getStationList(){
		return station_list;
	}
	public ArrayList<UserPO> getUserList(){
		return user_list;
	}
	public ArrayList<Carpo> getCarList(){
		return car_list;
	}
	
}
