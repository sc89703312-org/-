package client.blservice.accountblservice.test;

import java.nio.file.AccessMode;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.accountblservice.Accountblservice;
import client.po.Role;
import client.vo.accountvo.Accountvo;
import client.vo.carvo.Carvo;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;
import client.vo.uservo.UserVO;

public class Accountblservice_Driver {

	
	
	public void driver(Accountblservice a){
		
		ArrayList<HallVO> hall_list =  new 	ArrayList<HallVO>();
		ArrayList<StationVO> station_list  = new ArrayList<StationVO>();
		ArrayList<UserVO> user_list =  new 	ArrayList<UserVO>();
		ArrayList<Carvo> car_list =  new 		ArrayList<Carvo> ();
		
		hall_list.add(new HallVO("025001","南京", "025"));
		station_list.add(new StationVO("025000", "鼓楼营业厅"));
		user_list.add(new UserVO("sc", "CC", Role.POSTMAN, "hehe"));
		car_list.add(new Carvo(025000, "", "", "", "", 2));
		
		
		ResultMessage addMessage = a.createAccount(new Accountvo(hall_list,
				                                                     station_list, user_list, 
				                                                     car_list));
		
		if(addMessage==ResultMessage.VALID){
			System.out.println("Succeed");
		}else {
			System.out.println("Failed");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		a.endAccount();
		
	}
	
	
	public static void main(String [] s){
		new Accountblservice_Driver().driver(new Accountblservice_Stub());
	}
}
