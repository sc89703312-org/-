package edu.nju.express.businesslogic.hallbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.HallBLService;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.HallOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.HallPo;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.TransferReceiptVO;

public class HallBL implements HallBLService,HallOperationInfo {

	
	HallDataService hallDataService;
	
	
	public HallBL() {
		// TODO Auto-generated constructor stub
	
		
		hallDataService = RMIHelper.getHallDataService();
	}
	
	
	
	
	@Override
	public ResultMessage addHall(String id, String location) {
		// TODO Auto-generated method stub
		
		HallPo po = new HallPo(id, location);
		
		try {
			return hallDataService.addHall(po) ;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	@Override
	public ResultMessage removeHall(String id) {
		// TODO Auto-generated method stub
		try {
			return  hallDataService.removeHall(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	@Override
	public ArrayList<HallVO> showHall() {
		// TODO Auto-generated method stub
		try {
			return convertHallPO(hallDataService.showHall());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	
	
	public ArrayList<HallVO> convertHallPO (ArrayList<HallPo> polist){
		ArrayList<HallVO> halls = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			halls.add(new HallVO(polist.get(i).getId(), polist.get(i).getName()));
		}
		return halls;
	}
	

	

}
