package client.blservice.accountblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.accountblservice.Accountblservice;
import client.po.Role;
import client.vo.accountvo.Accountvo;
import client.vo.carvo.Carvo;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;
import client.vo.uservo.UserVO;

public class Accountblservice_Stub implements Accountblservice{

	@Override
	public ResultMessage createAccount(Accountvo vo) {
		// TODO Auto-generated method stub
		
		ResultMessage temp = ResultMessage.VALID;
		
		
		ArrayList<HallVO> hall_list = vo.getHallList();
		ArrayList<StationVO> station_list  = vo.getStationList();
		ArrayList<UserVO> user_list = vo.getUserList();
		ArrayList<Carvo> car_list = vo.getCarList();
		
		if(hall_list.get(0).getCityID()!="025")
			temp=ResultMessage.INVALID;
		if(hall_list.get(0).getId()!="025001")
			temp=ResultMessage.INVALID;
		if(station_list.get(0).getId()!="025000")
			temp=ResultMessage.INVALID;
		if(user_list.get(0).getId()!="sc")
			temp=ResultMessage.INVALID;
		if(car_list.get(0).getId()!=025000)
			temp=ResultMessage.INVALID;
		
		
		
		
		
		return temp;
	}

	@Override
	public Accountvo viewAccount(String date) {
		// TODO Auto-generated method stub
		
		
		ArrayList<HallVO> hall_list =  new 	ArrayList<HallVO>();
		ArrayList<StationVO> station_list  = new ArrayList<StationVO>();
		ArrayList<UserVO> user_list =  new 	ArrayList<UserVO>();
		ArrayList<Carvo> car_list =  new 		ArrayList<Carvo> ();
		
		hall_list.add(new HallVO("025001","南京", "025"));
		station_list.add(new StationVO("025000", "鼓楼营业厅"));
		user_list.add(new UserVO("sc", "CC", Role.POSTMAN, "hehe"));
		car_list.add(new Carvo(02500010, "", "", "", "", 2));
		
		
		
		return new Accountvo(hall_list, station_list, user_list, car_list);
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		System.out.println("Account Control ends");
	}

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		
	}

}
