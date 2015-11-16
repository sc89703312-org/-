package client.businesslogic.stationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.dataservice.stationdataservice.StationDataService;
import client.main.RMIHelper;
import client.po.stationpo.StationPO;
import client.vo.stationvo.StationVO;

public class StationBl {
	
	StationDataService stationDataService;
	
	public StationBl(){
		//stationDataService = RMIHelper.getStationDataService();
	}

	public ResultMessage addStation(String id, String location){
		
		ResultMessage result = null;
		
		try {
			result = stationDataService.addStation(id, location);
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
