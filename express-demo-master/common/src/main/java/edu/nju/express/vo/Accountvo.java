package edu.nju.express.vo;

import java.util.ArrayList;




public class Accountvo {
	ArrayList<HallVO> hall_list = new ArrayList<HallVO>();
	ArrayList<StationVO> station_list  = new ArrayList<StationVO>();
	ArrayList<EmployeeVO> user_list = new ArrayList<EmployeeVO>();
	ArrayList<Carvo> car_list = new ArrayList<Carvo>();
	ArrayList<BankingAccountVO> bank_list = new ArrayList<BankingAccountVO>();
	ArrayList<ComGoodsVO> goods_list = new ArrayList<ComGoodsVO>();
	String date;
	
	
	
	public Accountvo(ArrayList<HallVO> hall_list,
			                ArrayList<StationVO> station_list,
			                ArrayList<EmployeeVO> user_list,
			                ArrayList<Carvo> car_list ,
			                ArrayList<BankingAccountVO> bank_list,
			                ArrayList<ComGoodsVO> goods_list,
			                String date) {
		// TODO Auto-generated constructor stub

	
	this.hall_list = hall_list;
	this.station_list = station_list;
	this.user_list = user_list;
	this.car_list = car_list;
	this.bank_list = bank_list;
	this.goods_list = goods_list;
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
	public ArrayList<ComGoodsVO> getCommodity(){
		return goods_list;
	}
	public String getDate(){
		return date;
	}
}
