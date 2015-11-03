package client.businesslogic.vehiclebl;

import java.rmi.RemoteException;

import client.ResultMessage;
import client.blservice.vehicleblservice.CarControlService;
import client.dataservice.vehicledataservice.vehicledataservice;
import client.main.RMIHelper;
import client.po.carpo.Carpo;
import client.vo.carvo.Carvo;

public class CarControl implements CarControlService{

	vehicledataservice vehicledataservice;
	
	
	public CarControl() {
		// TODO Auto-generated constructor stub
	vehicledataservice = RMIHelper.getVehicleDataService();
	}
	
	
	
	@Override
	public ResultMessage addCar(Carvo vo) {
		// TODO Auto-generated method stub
		try {
			vehicledataservice.insertCar(convertVO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage deleteCar(int id) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findCar(id)!=null){
				vehicledataservice.deleteCar(id);
			}else {
				System.out.println("The id of car doesn't exsit");
				return ResultMessage.INVALID;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage modifyCar(int id, Carvo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carvo viewCar(int id) {
		// TODO Auto-generated method stub
		
		Carvo tempCarvo = null;
		
		try {
			if(vehicledataservice.findCar(id)!=null)
				tempCarvo = convertPO(vehicledataservice.findCar(id));
			else {
				System.out.println("The id of car doesn't exsit");
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempCarvo;
	}

	@Override
	public void endCar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public Carpo convertVO(Carvo vo){
		return new Carpo(vo.getId(), vo.getMotor(),
				                 vo.getCar(), vo.getBase(),
				                 vo.getPurchase(), vo.getUse());
	}
	
	
	public Carvo convertPO(Carpo po){
		return new Carvo(po.getId(), po.getMotor(),
				                 po.getCar(), po.getBase(),
				                 po.getPurchase() ,po.getUse());
	}

}
