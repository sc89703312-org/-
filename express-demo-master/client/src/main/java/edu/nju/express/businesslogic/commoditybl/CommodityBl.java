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
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;
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
	public ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, Object data[][]) {
		// TODO Auto-generated method stub
		
		ComZonePO comZonePO = null;
		try {
			comZonePO = commodityDataService.getZone(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int shelfPerLine = comZonePO.getShelfPerLine();
		int cellPerShelf = comZonePO.getCellPerShelf();
		
		boolean isEmptyPlane[] = comZonePO.getIsEmptyPlane();
		boolean isEmptyTrain[] = comZonePO.getIsEmptyTrain();
		boolean isEmptyCar[] = comZonePO.getIsEmptyCar();
		boolean isEmptyTem[] = comZonePO.getIsEmptyTem();
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				if(isEmptyPlane[index])
					isEmptyPlane[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("铁运区"))
				if(isEmptyTrain[index])
					isEmptyTrain[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("汽运区"))
				if(isEmptyCar[index])
					isEmptyCar[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("机动区"))
				if(isEmptyTem[index])
					isEmptyTem[index] = false;
				else
					return ResultMessageV2.ERROR;
		}
		
        vo.setComGoods(data);
		
		return ResultMessageV2.SUCCESS;
	}

	@Override
	public void subEnterReceipt(EnterReceiptVO vo) {
		// TODO Auto-generated method stub
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(stationInfo.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));
			
		EnterReceiptPO po = new EnterReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		try {
			commodityDataService.addEnterReceipt(comID, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<TransferReceiptVO> showTransferReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveTransfer();
	}

	@Override
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		
		ArrayList<OrderVO> orderList = vo.getList();
		ArrayList<ComGoodsVO> comGoodsList = new ArrayList<ComGoodsVO>();
		
		for(int i=0;i<orderList.size();i++){
			ComGoodsPO goodpo = null;
			try {
				goodpo = commodityDataService.getGoods(comID, orderList.get(i).getID());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ComGoodsVO goodvo = new ComGoodsVO(orderList.get(i),goodpo.getType(),goodpo.getLine(),goodpo.getShelf(),goodpo.getCell());
			comGoodsList.add(goodvo);
		}
		
		try {
			return new ExitReceiptVO(comGoodsList,commodityDataService.getNextExitID(comID),location,Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void subExitReceipt(ExitReceiptVO vo) {
		// TODO Auto-generated method stub
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(stationInfo.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));
			
		ExitReceiptPO po = new ExitReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		try {
			commodityDataService.addExitReceipt(comID, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ComGoodsVO> showInventory() {
		// TODO Auto-generated method stub
		
		ComInfoPO compo = null;
		try {
			compo = commodityDataService.getCom(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
		ArrayList<ComGoodsPO> polist = compo.getComGoodsList();
		
		for(int i=0;i<polist.size();i++){
			ComGoodsVO vo = new ComGoodsVO(stationInfo.po_to_vo_order(polist.get(i).getOrder()),polist.get(i).getType(),polist.get(i).getLine(),polist.get(i).getShelf(),polist.get(i).getCell());
			volist.add(vo);
		}
		
		return volist;
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

	@Override
	public ResultMessageV2 moveGoods(Object[][] data) {
		// TODO Auto-generated method stub
		
		ComZonePO comZonePO = null;
		try {
			comZonePO = commodityDataService.getZone(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int shelfPerLine = comZonePO.getShelfPerLine();
		int cellPerShelf = comZonePO.getCellPerShelf();
		
		boolean isEmptyPlane[] = comZonePO.getIsEmptyPlane();
		boolean isEmptyTrain[] = comZonePO.getIsEmptyTrain();
		boolean isEmptyCar[] = comZonePO.getIsEmptyCar();
		boolean isEmptyTem[] = comZonePO.getIsEmptyTem();
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				if(isEmptyPlane[index])
					isEmptyPlane[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("铁运区"))
				if(isEmptyTrain[index])
					isEmptyTrain[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("汽运区"))
				if(isEmptyCar[index])
					isEmptyCar[index] = false;
				else
					return ResultMessageV2.ERROR;
			if(type.equals("机动区"))
				if(isEmptyTem[index])
					isEmptyTem[index] = false;
				else
					return ResultMessageV2.ERROR;
		}
		
		commodityDataService.moveGoods(comID, data);
		
		return ResultMessageV2.SUCCESS;
	}

	
	
}
