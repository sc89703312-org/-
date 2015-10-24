package client.blservice.vehicleblservice.test;

import client.ResultMessage;
import client.blservice.vehicleblservice.CarControlService;
import client.vo.carvo.Carvo;
import client.vo.drivervo.Drivervo;

public class CarControlService_Stub implements CarControlService {

	@Override
	public ResultMessage addCar(Carvo vo) {
		// TODO Auto-generated method stub
		
		
		ResultMessage temp = ResultMessage.VALID;
		
		if(vo.getId()>=02500001&&vo.getId()<=02500020)
		{
			System.out.println("The id of car has been exsited!!!");
			temp = ResultMessage.INVALID;
		}else if(vo.getId()==02500021) {
			System.out.println("The id of car is valid");
			
		}else {
			System.out.println("Sorry, the format of id is invalid");
		    temp= ResultMessage.INVALID;
		}
		
		return temp;
	}

	@Override
	public ResultMessage deleteCar(int id) {
		// TODO Auto-generated method stub
		
		
		ResultMessage temp = ResultMessage.VALID;
	    if(id<=02500020&&id>=02500001){
	    	System.out.println("The id of car exsits");
	    	System.out.println("The id:"+id+" car has been deleted");
	    }else {
			System.out.println("Sorry,the id of car doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		return temp;
	}

	@Override
	public ResultMessage modifyCar(int id, Carvo vo) {
		// TODO Auto-generated method stub
		
		ResultMessage temp = ResultMessage.VALID;
		
		if(id>=02500001&&id<=02500020){
			System.out.println("The id of car exsits");
		}else {
			System.out.println("Sorry,the id of car doesn't exsit");
			temp = ResultMessage.INVALID;
		}
		
		
		if((vo.getId()>=02500001&&vo.getId()<=02500020&&vo.getId()!=id))
		{
			System.out.println("The id of car has been exsited!!!");
			temp = ResultMessage.INVALID;
		}else if(vo.getId()==02500021||vo.getId()==id) {
			System.out.println("The id of car is valid");
			
		}else {
			System.out.println("Sorry, the format of id is invalid");
		    temp= ResultMessage.INVALID;
		}
		
		
		return temp;
	}

	@Override
	public Carvo viewCar(int id) {
		// TODO Auto-generated method stub
		
	    if(id<=02500020&&id>=02500001){
	    	System.out.println("The id of car exsits");
	    	System.out.println("The id:"+id+" car has been showed");
	    	return new Carvo(id, "motor-1", "À’A-8976", "base-1", "2011/9/12", 4);
	    }else {
			System.out.println("Sorry,the id of car doesn't exsit");
			return null;
		}
		
	
		
		
	}

	@Override
	public void endCar() {
		// TODO Auto-generated method stub
		System.out.println("The control of car ends");
	}

}
