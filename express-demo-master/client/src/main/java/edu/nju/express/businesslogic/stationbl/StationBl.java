package edu.nju.express.businesslogic.stationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataservice.CommodityDataService;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.StationPO;
import edu.nju.express.vo.StationVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:38
 * 
 *  中转中心聚业务逻辑模块，用于实现中转中心的增删改查
 *
 */

public class StationBl implements StationOperationInfo{
	
	/* 中转中心模块数据层的接口 */
	StationDataService stationDataService;
	/* 仓库模块数据层的接口 */
	CommodityDataService commodityDataService;
	
	/*
	 * 构造方法
	 */
	public StationBl(){
		try {
			
			stationDataService = (StationDataService)Naming.lookup("rmi://" + RMIConfig.HOST + "/station-service");
		
			commodityDataService = (CommodityDataService)Naming.lookup("rmi://" + RMIConfig.HOST + "/commodity-service");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo#addStation(java.lang.String, java.lang.String)
	 * @author ShiroKo
	 * @version 2015-12-9 22:36
	 */
	public ResultMessage addStation(String id, String location){
		
		ResultMessage result = null;
		
		try {
			result = stationDataService.addStation(id, location);
			commodityDataService.addCommodity(id,location,1000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo#deleteStation(java.lang.String)
     * @author ShiroKo
	 * @version 2015-12-9 22:36
     */
	public ResultMessage deleteStation(String id){
		
        ResultMessage result = null;
		
		try {
			result = stationDataService.removeStation(id);
			commodityDataService.removeCommodity(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo#showStation()
     * @author ShiroKo
	 * @version 2015-12-9 22:36
     */
    public ArrayList<StationVO> showStation() {
    	
    	ArrayList<StationPO> poList = null;
    	
    	try {
	        poList = stationDataService.showStation();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ArrayList<StationVO> voList = new ArrayList<StationVO>();
    	for(int i=0;i<poList.size();i++){
    		StationVO stationvo = new StationVO(poList.get(i).getId(),poList.get(i).getName());
    		voList.add(stationvo);
    	}
    	
    	return voList;
    	
    }
	
}
