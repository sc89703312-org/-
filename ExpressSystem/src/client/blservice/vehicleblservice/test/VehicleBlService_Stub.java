package client.blservice.vehicleblservice.test;

import client.ResultMessage;
import client.blservice.vehicleblservice.Vehicleblservice;
import client.vo.drivervo.Drivervo;

public class VehicleBlService_Stub implements Vehicleblservice {

	
	
	
	@Override
	public ResultMessage addDriver(Drivervo vo) {
		// TODO Auto-generated method stub
		
		ResultMessage temp = ResultMessage.VALID;
		
		
		if(vo.getId()>=025000000&&vo.getId()<=025000100)
		{
			System.out.println("The id of driver has been exsited");
			temp = ResultMessage.INVALID;
		}else if (vo.getId()==025000101) {
			System.out.println("The id of driver is valid");
		}else {
			temp = ResultMessage.INVALID;
			System.out.println("Sorry,the format of id is invalid");
		}
		
		
		
		if(vo.getHallId().equals("025000")){
			System.out.println("The id of Hall exsits");
		}else {
			temp = ResultMessage.INVALID;
			System.out.println("Sorry, the id of hall doesn't exsit.");
		}
		
		
	
		
		return temp;
	}

	@Override
	public ResultMessage deleteDriver(int id) {
		// TODO Auto-generated method stub
		
		
		ResultMessage temp = ResultMessage.VALID;
		
		if(id>=025000000&&id<=025000100){
			System.out.println("The id of driver exsits");
		}else {
			System.out.println("The id of driver doesn't exsit");
			temp = ResultMessage.INVALID;
		}
			return temp;
		
	}

	@Override
	public ResultMessage modifyDriver(int id,Drivervo vo) {
		// TODO Auto-generated method stub
		
      ResultMessage temp = ResultMessage.VALID;
		
		if(id>=025000000&&id<=025000100){
			System.out.println("The id of driver exsits");
		}else {
			System.out.println("The id of driver doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		
		if(vo.getId()<=025000100&&vo.getId()>=025000000)
		{
			System.out.println("The id of driver has been exsited");
			temp = ResultMessage.INVALID;
		}else if (vo.getId()==025000101) {
			System.out.println("The id of driver is valid");
		}else {
			temp = ResultMessage.INVALID;
			System.out.println("Sorry,the format of id is invalid");
		}
		
		
		if(vo.getHallId().equals("025000")){
			System.out.println("The id of Hall exsits");
		}else {
			temp = ResultMessage.INVALID;
			System.out.println("Sorry, the id of hall doesn't exsit.");
		}
		
		
		return temp;
	}

	@Override
	public Drivervo viewDriver(int id) {
		// TODO Auto-generated method stub
		
		if(id<=025000100&&id>=025000000){
			System.out.println("The id of driver exsits");
			return new Drivervo(id, "XiaoLiu", "1996/7/11", "321283199607110010",
					"18351890150", "025000", true, "2018/7/10");
		}
		
		else {
			System.out.println("The id of driver doesn't exsit");
			return null;
		}
		
	}

	@Override
	public void endVehicle() {
		// TODO Auto-generated method stub
		System.out.println("The control of vehicle ends");
	}

	
	
}
