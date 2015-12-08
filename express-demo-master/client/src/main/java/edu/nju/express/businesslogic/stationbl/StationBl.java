package edu.nju.express.businesslogic.stationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.CommodityDataService;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.StationPO;
import edu.nju.express.vo.StationVO;


public class StationBl implements StationOperationInfo{
	
	StationDataService stationDataService;
	CommodityDataService commodityDataService;
	
	public StationBl(){
		stationDataService = RMIHelper.getStationDataService();
		commodityDataService = RMIHelper.getCommodityDataService();
	}

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
