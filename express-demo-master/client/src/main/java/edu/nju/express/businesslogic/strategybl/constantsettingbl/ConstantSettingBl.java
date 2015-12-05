package edu.nju.express.businesslogic.strategybl.constantsettingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.ConstantAddCityInfo;
import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.ConstantDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.ConstantVO;



public class ConstantSettingBl implements ConstantSettingBlService,ConstantAddCityInfo {

	
	
	public static ConstantDataService constantDataService = RMIHelper.getConstantDataService();
	
	
	public ConstantSettingBl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		
		LogController.insertLog(new LogMessage("Set Distance", LoginInfo.getUserName()));
		try {
			constantDataService.setCityDistance(id1, id2, distance);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setPrice(double p) {
		
		
		LogController.insertLog(new LogMessage("Set Price", LoginInfo.getUserName()));
		
		
		
		if (p <= 0)
			return ResultMessage.INVALID;
//		BasicValues.price = p;
		try {
			constantDataService.setPrice(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setVehicleCost(double van, double railway, double airplane) {
		
		
		LogController.insertLog(new LogMessage("Set VehicleCost", LoginInfo.getUserName()));
		
		
		
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.INVALID;
//		BasicValues.vanCost = van;
//		BasicValues.railwayCost = railway;
//		BasicValues.airplaneCost = airplane;
		
		try {
			constantDataService.setVehicleCost(van, railway, airplane);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
	
		LogController.insertLog(new LogMessage("Set VehicleLoad", LoginInfo.getUserName()));
		
		
		
		
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.INVALID;
		
//		BasicValues.airplaneLoad = airplane;
//		BasicValues.vanLoad = van;
//		BasicValues.railwayLoad = railway;
		
		try {
			constantDataService.setVehicleLoad(van, railway, airplane);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	
	
	
	
	public void addCity(String CityID){
		
		LogController.insertLog(new LogMessage("Add City", LoginInfo.getUserName()));
		
		
		try {
			constantDataService.addCity(CityID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<String> getCityList(){
		try {
			return constantDataService.getCityList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<String> getCityDistance(){
	try {
		return	constantDataService.getCityDistance();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
	
	
	
	public static double getPrice(){
		try {
			return constantDataService.getPrice();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static double[] getVehicleCost(){
		try {
			return constantDataService.getVehicleCost();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int[] getVehicleLoad(){
		try {
			return constantDataService.getVehicleLoad();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public ConstantVO getConstant() {
		// TODO Auto-generated method stub
		try {
			return new ConstantVO(constantDataService.getCityList(),
					constantDataService.getCityDistance(),
					constantDataService.getPrice()+"",
					constantDataService.getPrice()*18/23+"",
					constantDataService.getPrice()*25/23+"", 
					constantDataService.getVehicleCost()[0]+"",
					constantDataService.getVehicleCost()[1]+"", 
					constantDataService.getVehicleCost()[2]+"",
					constantDataService.getVehicleLoad()[0]+"", 
					constantDataService.getVehicleLoad()[1]+"",
					constantDataService.getVehicleLoad()[2]+"");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
