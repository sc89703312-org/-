package edu.nju.express.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.StationPO;
import edu.nju.express.vo.StationVO;

public class MockStation extends StationBl{

	ArrayList<StationPO> list = new ArrayList<StationPO>();

	MockStation(){
		list.add(new StationPO("025", "Nanjing"));
		list.add(new StationPO("026", "Unknown"));
	}
	
	@Override
	public ResultMessage addStation(String id, String location){
		
		if(id.equals("025")||id.equals("026"))
			return ResultMessage.INVALID;
		
		list.add(new StationPO(id, location));
		
		return ResultMessage.VALID;
		
	}
	
	@Override
	public ResultMessage deleteStation(String id){
		
        if(!id.equals("025")&&!id.equals("026"))
        	return ResultMessage.INVALID;


		return ResultMessage.VALID;
		
	}
	@Override
    public ArrayList<StationVO> showStation() {
    	
    	ArrayList<StationVO> poList = new ArrayList<StationVO>();
    	poList.add(new StationVO("025", "Nanjing"));
    	poList.add(new StationVO("026", "Unknown"));
    	return poList;
    	
    }
}
