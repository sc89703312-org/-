package edu.nju.express.businesslogic.strategybl.constantsettingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.ConstantDataService;
import edu.nju.express.init.RMIHelper;



public class ConstantSettingBl implements ConstantSettingBlService {

	
	
	public static ConstantDataService constantDataService = RMIHelper.getConstantDataService();
	
	
	public ConstantSettingBl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPrice(double p) {
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
}
