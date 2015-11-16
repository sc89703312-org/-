package client.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.businesslogic.hallbl.HallBL;
import client.po.HallPo.HallPo;
import client.vo.hallvo.HallVO;

public class MockHall extends HallBL{

	ArrayList<HallPo> list = new ArrayList<HallPo>();

	MockHall(){
		list.add(new HallPo("0250001", "Nanjing","025"));
		list.add(new HallPo("026001","Unknown","026"));
	}
	@Override
	public ResultMessage addHall(String id, String location,String cityID){
		
		if(id.equals("025001")||id.equals("026001"))
			return ResultMessage.INVALID;
		
		list.add(new HallPo(id, location, id.substring(0,3)));
		
		return ResultMessage.VALID;
		
	}
	@Override
	public ResultMessage removeHall(String id){
		
        if(!id.equals("025001")&&!id.equals("026001"))
        	return ResultMessage.INVALID;


		return ResultMessage.VALID;
		
	}
	
	@Override
    public ArrayList<HallVO> showHall() {
    	
    	ArrayList<HallVO> poList = new ArrayList<HallVO>();
		poList.add(new HallVO("0250001", "Nanjing","025"));
		poList.add(new HallVO("026001","Unknown","026"));
    	return poList;
    	
    }
	
}
