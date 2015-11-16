package client.vo.accountvo;

import java.util.ArrayList;

import client.vo.bankingvo.BankingAccountVO;
import client.vo.carvo.Carvo;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;
import client.vo.uservo.EmployeeVO;
import client.vo.uservo.UserVO;


public class Accountvo {
	ArrayList<HallVO> hall_list = new ArrayList<HallVO>();
	ArrayList<StationVO> station_list  = new ArrayList<StationVO>();
	ArrayList<EmployeeVO> user_list = new ArrayList<EmployeeVO>();
	ArrayList<Carvo> car_list = new ArrayList<Carvo>();
	ArrayList<BankingAccountVO> bank_list = new ArrayList<BankingAccountVO>();
	String date;
	
	
	
	public Accountvo(ArrayList<HallVO> hall_list,
			                ArrayList<StationVO> station_list,
			                ArrayList<EmployeeVO> user_list,
			                ArrayList<Carvo> car_list ,
			                ArrayList<BankingAccountVO> bank_list,
			                String date) {
		// TODO Auto-generated constructor stub

	
	this.hall_list = hall_list;
	this.station_list = station_list;
	this.user_list = user_list;
	this.car_list = car_list;
	this.bank_list = bank_list;
	this.date = date;
	}
	
	public ArrayList<HallVO> getHallList(){
		return hall_list;
	}
	
	public ArrayList<StationVO> getStationList(){
		return station_list;
	}
	public ArrayList<EmployeeVO> getUserList(){
		return user_list;
	}
	public ArrayList<Carvo> getCarList(){
		return car_list;
	}
	public ArrayList<BankingAccountVO> getAccountList(){
		return bank_list;
	}
	public String getDate(){
		return date;
	}
}
