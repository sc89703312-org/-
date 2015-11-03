package client.businesslogic.vehiclebl;

import java.rmi.RemoteException;

import client.ResultMessage;
import client.blservice.vehicleblservice.Vehicleblservice;
import client.dataservice.vehicledataservice.vehicledataservice;
import client.main.RMIHelper;
import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;
import client.vo.carvo.Carvo;
import client.vo.drivervo.Drivervo;


public class Vehiclebl implements Vehicleblservice{

	vehicledataservice vehicledataservice ;
	
	
	public Vehiclebl() {
		// TODO Auto-generated constructor stub
	vehicledataservice = RMIHelper.getVehicleDataService();
	}
	
	
	@Override
	public ResultMessage addDriver(Drivervo vo) {
		// TODO Auto-generated method stub
		try {
			if(vehicledataservice.findDri(vo.getId())!=null){
				System.out.println("Sorry the id of driver has been exsited");
				return ResultMessage.INVALID;
			}else {
				System.out.println("The id is valid");
				vehicledataservice.insertDri(convertVO(vo));
			}
			  
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage deleteDriver(int id) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				System.out.println("The id of driver exsits");
				vehicledataservice.deleteDri(id);
			}else {
				System.out.println("The id of driver doesn't exsit");
				return ResultMessage.INVALID;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage modifyDriver(int id, Drivervo vo) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				vehicledataservice.updateDri(id, convertVO(vo));
			}else {
				System.out.println("The id doesn't exsit");
				return ResultMessage.INVALID;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	@Override
	public Drivervo viewDriver(int id) {
		// TODO Auto-generated method stub
		
		Drivervo tempDrivervo = null;
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				tempDrivervo = convertPO(vehicledataservice.findDri(id));			
			}else {
				System.out.println("The id of driver doesn't exsit");
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempDrivervo;
	}

	@Override
	public void endVehicle() {
		// TODO Auto-generated method stub
		System.out.println("End the driver control");
	}
	
	
	
	
	public Driverpo convertVO(Drivervo vo){
		return new Driverpo(vo.getId(), vo.getName(),
				                     vo.getBirthDate(), vo.getCertificate(),
				                     vo.getPhone(), vo.getHallId(),
				                     vo.getSex(), vo.getDdl());
	}
	
	
	public Drivervo convertPO(Driverpo po){
		return new Drivervo(po.getId(), po.getName(),
				                 po.getBirthDate(), po.getCertificate(),
				                 po.getPhone() ,po.getHallId(),
				                 po.getSex(),po.getDdl());
	}
	
	
	
	
	

}
