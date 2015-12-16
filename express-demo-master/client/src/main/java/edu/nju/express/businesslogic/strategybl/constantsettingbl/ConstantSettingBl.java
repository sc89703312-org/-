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


/**
 * 常量制定的功能实现
 * @author Dora
 * @version 2015-12-9 23:18:41
 * 
 */
public class ConstantSettingBl implements ConstantSettingBlService,ConstantAddCityInfo {

	
	
	public static ConstantDataService constantDataService = RMIHelper.getConstantDataService();
	
	
	public ConstantSettingBl() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 *从数据层获得两城市之间距离的功能实现
	 * @see edu.nju.express.blservice.ConstantSettingBlService#setDistance(java.lang.String, java.lang.String, double)
	 */
	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		
		LogController.insertLog(new LogMessage("设定城市距离", LoginInfo.getUserName()));
		try {
			constantDataService.setCityDistance(id1, id2, distance);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	/*
	 * 设置标准快递价格
	 * @see edu.nju.express.blservice.ConstantSettingBlService#setPrice(double)
	 */
	@Override
	public ResultMessage setPrice(double p) {
		
		
		LogController.insertLog(new LogMessage("设定价格", LoginInfo.getUserName()));
		
		
		
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

	/*
	 * 设置交通运输成本
	 * @see edu.nju.express.blservice.ConstantSettingBlService#setVehicleCost(double, double, double)
	 */
	@Override
	public ResultMessage setVehicleCost(double van, double railway, double airplane) {
		
		
		LogController.insertLog(new LogMessage("设置交通费用", LoginInfo.getUserName()));
		
		
		
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

	/*
	 * 设置交通运输载量
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.ConstantSettingBlService#setVehicleLoad(int, int, int)
	 */
	@Override
	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
	
		LogController.insertLog(new LogMessage("设置承载量", LoginInfo.getUserName()));
		
		
		
		
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

	
	
	/*
	 * 增加城市
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.strategybl.organizationbl.Info.ConstantAddCityInfo#addCity(java.lang.String, java.lang.String)
	 */
	
	public void addCity(String CityID,String id){
		
		LogController.insertLog(new LogMessage("新增城市", LoginInfo.getUserName()));
		
		
		try {
			constantDataService.addCity(CityID,id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 获取城市名称列表
	 */
	public static ArrayList<String> getCityList(){
		try {
			return constantDataService.getCityList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获取城市距离列表
	 */
	public static ArrayList<String> getCityDistance(){
	try {
		return	constantDataService.getCityDistance();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
	
	
	/*
	 * 获取标准快递价格
	 */
	public static double getPrice(){
		try {
			return constantDataService.getPrice();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * 获取运输成本
	 */
	public static double[] getVehicleCost(){
		try {
			return constantDataService.getVehicleCost();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获取运输载量
	 */
	public static int[] getVehicleLoad(){
		try {
			return constantDataService.getVehicleLoad();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/*
	 * 得到常量显示的vo
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.ConstantSettingBlService#getConstant()
	 */
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



	/*
	 * 从数据层删除城市
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.strategybl.organizationbl.Info.ConstantAddCityInfo#deleteCity(java.lang.String)
	 */
	@Override
	public void deleteCity(String CityID) {
		// TODO Auto-generated method stub
		try {
			constantDataService.deleteCity(CityID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
