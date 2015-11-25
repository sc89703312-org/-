package edu.nju.express.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.Etype;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.dataservice.CommodityDataService;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.ComZoneVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public class CommodityBl implements CommodityBlService{
	
	CommodityDataService commodityDataService;
	StationInfo stationInfo;
	String userID;
	String comID;
	String location;
	
	public CommodityBl(StationInfo stationInfo, String userID){
		this.stationInfo = stationInfo;
		this.userID = userID;
		comID = userID.substring(0, userID.length()-2);
		try {
			location = commodityDataService.getLocation(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArriveReceiptVO> showArriveReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveArrive();
	}

	@Override
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) throws Exception{
		// TODO Auto-generated method stub
		
		ArrayList<OrderVO> orderList = vo.getList();
		ArrayList<ComGoodsVO> comGoodsList = new ArrayList<ComGoodsVO>();
		ComZonePO zonePO = null;
		
		try {
		    zonePO = commodityDataService.getZone(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<orderList.size();i++){
			
			Etype etype = orderList.get(i).getType();
	        int result[];
			
	        if(etype==Etype.FAST)
				result = zonePO.selectCell(1);
			else 
				if(etype==Etype.STANDARD)
				    result = zonePO.selectCell(2);
			    else
				    result = zonePO.selectCell(3);
	        
	        if(result[0]==0)
	        	throw new Exception();
	        
	        int type = result[0];
	        int line = result[1]/(zonePO.getCellPerShelf()*zonePO.getShelfPerLine())+1;
	        int shelf = (result[1] - (line-1)*zonePO.getShelfPerLine())/zonePO.getCellPerShelf()+1;
	        int cell = result[1] - (line-1)*zonePO.getCellPerShelf()*zonePO.getShelfPerLine()-(shelf-1)*zonePO.getCellPerShelf();
	        
	        comGoodsList.add(new ComGoodsVO(orderList.get(i),type,line,shelf,cell));
	        
		}
		
		return new EnterReceiptVO(comGoodsList,commodityDataService.getNextEnterID(comID),location,Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE);
	}

	@Override
	public ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, String orderID) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public void subEnterReceipt(EnterReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TransferReceiptVO> showTransferReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveTransfer();
	}

	@Override
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subExitReceipt(ExitReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ComGoodsVO> showInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void outputInventory(ArrayList<ComGoodsVO> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] showCheck(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComZoneVO showZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage editZone(ComZoneVO vo, int[] space) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subZone(ComZoneVO vo) {
		// TODO Auto-generated method stub
		
	}

	
	
}
