package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;




public class Accountpo extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** 营业厅列表 */
	ArrayList<HallPo> hall_list = new ArrayList<HallPo>();
	/** 中转中心列表 */
	ArrayList<StationPO> station_list  = new ArrayList<StationPO>();
	/** 用户列表 */
	ArrayList<UserPO> user_list = new ArrayList<UserPO>();
	/** 车辆列表 */
	ArrayList<Carpo> car_list = new ArrayList<Carpo>();
	/** 银行账户列表 */
	ArrayList<BankingAccountPO> bank_list = new ArrayList<BankingAccountPO>();
	/** 库存列表*/
    ArrayList<ComGoodsPO> goods_list = new ArrayList<ComGoodsPO>();
	
	
	//	String date;
	
	
	
	
	
	
	public Accountpo(ArrayList<HallPo> hall_list,
			                ArrayList<StationPO> station_list,
			                ArrayList<UserPO> user_list,
			                ArrayList<Carpo> car_list,
			                ArrayList<BankingAccountPO> bank_list,
			                ArrayList<ComGoodsPO> goods_list,
			                String date) {
		
		// TODO Auto-generated constructor stub
  
	
	this.hall_list = hall_list;
	this.station_list = station_list;
	this.user_list = user_list;
	this.car_list = car_list;
	this.bank_list = bank_list;
	this.goods_list = goods_list;
	this.date = date;
	this.id = date ;
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
	
	public ArrayList<BankingAccountPO> getAccountsList(){
		return bank_list;
	}
	public ArrayList<ComGoodsPO> getCommodity() {
		return goods_list;
		
	}
	
	

	
}
