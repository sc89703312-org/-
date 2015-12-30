package edu.nju.express.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.accountbl.Info.CommodityInfo;
import edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo;
import edu.nju.express.common.Convert;
import edu.nju.express.common.Etype;
import edu.nju.express.common.MyDate;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.dataservice.CommodityDataService;
import edu.nju.express.init.RMIHelper;
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
import static edu.nju.express.init.RMIHelper.commodityDataService;
/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:51
 * 
 * 仓库的业务逻辑模块，实现仓库及其单据、货物的增删改查
 *
 */

public class CommodityBl implements CommodityBlService,CommodityInfo, CommodityApproveInfo{
	
	/* 仓库模块的数据层接口 */
	/* 获得仓库需要的中转中心单据的中转模块接口 */
	StationInfo stationInfo;
	/* 用户ID */
	String userID;
	/* 仓库ID */
	String comID;
	/* 仓库位置 */
	String location;
	
	/* 正在处理的到达单ID */
	String currentArriveID;
	/* 正在处理的中转单单ID */
	String currentTransferID;
	
	/*
	 * 构造方法
	 */
	public CommodityBl(StationInfo stationInfo, String userID){
		this.stationInfo = stationInfo;
		this.userID = userID;
	}
    
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showArriveReceiptList()
	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<ArriveReceiptVO> showArriveReceiptList() {
		// TODO Auto-generated method stub
		comID = userID.substring(0, 3);
		return stationInfo.viewApproveArrive(comID);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showEnterReceipt(edu.nju.express.vo.ArriveReceiptVO)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) throws Exception{
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		try {
			location = commodityDataService.getLocation(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentArriveID = vo.getId();
		
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
		System.out.println(commodityDataService.getNextEnterID(comID));
		return new EnterReceiptVO(comGoodsList,commodityDataService.getNextEnterID(comID),MyDate.getCurrentDate(),location);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#editEnterReceipt(edu.nju.express.vo.EnterReceiptVO, java.lang.Object[][])
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, Object data[][]) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#subEnterReceipt(edu.nju.express.vo.EnterReceiptVO)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public void subEnterReceipt(EnterReceiptVO vo) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(Convert.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));

		EnterReceiptPO po = new EnterReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		try {
			commodityDataService.addEnterReceipt(po);
			stationInfo.handleArrive(currentArriveID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showTransferReceiptList()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<TransferReceiptVO> showTransferReceiptList() {
		// TODO Auto-generated method stub
		comID = userID.substring(0, 3);
		return stationInfo.viewApproveTransfer(comID);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showExitReceipt(edu.nju.express.vo.TransferReceiptVO)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		try {
			location = commodityDataService.getLocation(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentTransferID = vo.getId();
		
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
			return new ExitReceiptVO(comGoodsList,commodityDataService.getNextExitID(comID),MyDate.getCurrentDate(),location);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#subExitReceipt(edu.nju.express.vo.ExitReceiptVO)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public void subExitReceipt(ExitReceiptVO vo) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(Convert.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));
			
		ExitReceiptPO po = new ExitReceiptPO(goodspo,vo.getId(),vo.getDate(),vo.getLocation());
		try {
			System.out.println(po);
			commodityDataService.addExitReceipt(po);
			stationInfo.handleTransfer(currentTransferID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showInventory()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<ComGoodsVO> showInventory() {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
		ArrayList<ComGoodsPO> polist = null;
		try {
			polist = commodityDataService.getComGoods(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<polist.size();i++){
			ComGoodsVO vo = new ComGoodsVO(Convert.po_to_vo_order(polist.get(i).getOrder()),polist.get(i).getType(),polist.get(i).getLine(),polist.get(i).getShelf(),polist.get(i).getCell());
			volist.add(vo);
		}
		
		return volist;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#outputInventory(java.util.ArrayList)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public void outputInventory(ArrayList<ComGoodsVO> list) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showCheck(java.lang.String, java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public int[] showCheck(String start, String end) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		int result[] = new int[20];
		for(int i=0;i<20;i++)
			result[i] = 0;
		
		try {
			ArrayList<EnterReceiptPO> enterlist = commodityDataService.getEnterReceipt(comID);
			ArrayList<ExitReceiptPO> exitlist = commodityDataService.getExitReceipt(comID);
			
			for(int i=0;i<enterlist.size();i++){
				EnterReceiptPO tempo = enterlist.get(i);
				if(tempo.getDate().compareTo(end)<=0&&tempo.getDate().compareTo(start)>=0){
					ArrayList<ComGoodsPO> goodslist = tempo.getGoods();
					
					for(int j=0;j<goodslist.size();j++){
						result[0]++;
						ComGoodsPO good = goodslist.get(j);
						result[5]+=good.getOrder().getTotalCost();
						switch(good.getType()){
						case 1:result[1]++;result[6]+=good.getOrder().getTotalCost();break;
						case 2:result[2]++;result[7]+=good.getOrder().getTotalCost();break;
						case 3:result[3]++;result[8]+=good.getOrder().getTotalCost();break;
						case 4:result[4]++;result[9]+=good.getOrder().getTotalCost();break;
						}
					}			
					
				}							
			}
			
			for(int i=0;i<exitlist.size();i++){
				ExitReceiptPO tempo = exitlist.get(i);
				if(tempo.getDate().compareTo(end)<=0&&tempo.getDate().compareTo(start)>=0){
					ArrayList<ComGoodsPO> goodslist = tempo.getGoods();
					
					for(int j=0;j<goodslist.size();j++){
						result[10]++;
						ComGoodsPO good = goodslist.get(j);
						result[15]+=good.getOrder().getTotalCost();
						switch(good.getType()){
						case 1:result[11]++;result[16]+=good.getOrder().getTotalCost();break;
						case 2:result[12]++;result[17]+=good.getOrder().getTotalCost();break;
						case 3:result[13]++;result[18]+=good.getOrder().getTotalCost();break;
						case 4:result[14]++;result[19]+=good.getOrder().getTotalCost();break;
						}
					}			
					
				}							
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showCheckEnter(java.lang.String, java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<EnterReceiptVO> showCheckEnter(String start,String end){
		
		comID = userID.substring(0, 3);
		
		ArrayList<EnterReceiptPO> poList = null;
		try {
			poList = commodityDataService.getEnterReceipt(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<EnterReceiptVO> voList = new ArrayList<EnterReceiptVO>();
		for(int i=0;i<poList.size();i++)
			//if(poList.get(i).getDate().compareTo(start)>=0&&poList.get(i).getDate().compareTo(end)<=0)
				voList.add(Convert.po_to_vo_enter(poList.get(i)));
		return voList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showCheckExit(java.lang.String, java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<ExitReceiptVO> showCheckExit(String start,String end){
		
		comID = userID.substring(0, 3);
		
		ArrayList<ExitReceiptPO> poList = null;
		try {
			poList = commodityDataService.getExitReceipt(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ExitReceiptVO> voList = new ArrayList<ExitReceiptVO>();
		for(int i=0;i<poList.size();i++)
			if(poList.get(i).getDate().compareTo(start)>=0&&poList.get(i).getDate().compareTo(end)<=0)
				voList.add(Convert.po_to_vo_exit(poList.get(i)));
		return voList;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#showZone()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ComZoneVO showZone() {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
	   ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
	   ComZonePO zonepo = null;
	   try {
		zonepo = commodityDataService.getZone(comID);
		ArrayList<ComGoodsPO> polist = commodityDataService.getComGoods(comID);
		for(int i=0;i<polist.size();i++){
			ComGoodsPO tempo = polist.get(i);
			volist.add(new ComGoodsVO(Convert.po_to_vo_order(tempo.getOrder()),tempo.getType(),tempo.getLine(),tempo.getShelf(),tempo.getCell()));
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
		return new ComZoneVO(volist,zonepo.getSpace());
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#editZone(int[])
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessageV2 editZone(int[] space) {
		// TODO Auto-generated method stub

		comID = userID.substring(0, 3);
		
		ResultMessageV2 result = null;
		
		try {
			result = commodityDataService.modifyZone(comID, space);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#initZone()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessageV2 initZone() {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
        ResultMessageV2 result = null;
		
		try {
			result = commodityDataService.initZone(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CommodityBlService#moveGoods(java.lang.Object[][])
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessageV2 moveGoods(Object[][] data) {
		// TODO Auto-generated method stub
		
		comID = userID.substring(0, 3);
		
		ComZonePO comZonePO = null;
		try {
			comZonePO = commodityDataService.getZone(comID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int shelfPerLine = comZonePO.getShelfPerLine();
		int cellPerShelf = comZonePO.getCellPerShelf();
		int[] space = comZonePO.getSpace();
		
		boolean isEmptyPlane[] = comZonePO.getIsEmptyPlane();
		boolean isEmptyTrain[] = comZonePO.getIsEmptyTrain();
		boolean isEmptyCar[] = comZonePO.getIsEmptyCar();
		boolean isEmptyTem[] = comZonePO.getIsEmptyTem();
		
		for(int i=0;i<isEmptyPlane.length;i++)
			isEmptyPlane[i] = true;
		for(int i=0;i<isEmptyTrain.length;i++)
			isEmptyTrain[i] = true;
		for(int i=0;i<isEmptyCar.length;i++)
			isEmptyCar[i] = true;
		for(int i=0;i<isEmptyTem.length;i++)
			isEmptyTem[i] = true;
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			String type = (String) data[i][1];
			
			if(Integer.parseInt((String) data[i][3])>shelfPerLine||Integer.parseInt((String) data[i][3])<1||Integer.parseInt((String) data[i][4])>cellPerShelf||Integer.parseInt((String) data[i][4])<1)
				return ResultMessageV2.ERROR;
		
			if(type.equals("航空区")){
				if(index<0||index>space[0]-1)
					return ResultMessageV2.ERROR;
				if(isEmptyPlane[index])
					isEmptyPlane[index] = false;
				else
					return ResultMessageV2.ERROR;
			}
			if(type.equals("铁运区")){
				if(index<0||index>space[1]-1)
					return ResultMessageV2.ERROR;
				if(isEmptyTrain[index])
					isEmptyTrain[index] = false;
				else
					return ResultMessageV2.ERROR;
			}
			if(type.equals("汽运区")){
				if(index<0||index>space[2]-1)
					return ResultMessageV2.ERROR;
				if(isEmptyCar[index])
					isEmptyCar[index] = false;
				else
					return ResultMessageV2.ERROR;
			}
			if(type.equals("机动区")){
				if(index<0||index>space[3]-1)
					return ResultMessageV2.ERROR;
				if(isEmptyTem[index])
					isEmptyTem[index] = false;
				else
					return ResultMessageV2.ERROR;
			}
		}
		
		try {
			commodityDataService.moveGoods(comID, data);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResultMessageV2.SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#viewAllEnterReceiptSubmitted()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<EnterReceiptVO> viewAllEnterReceiptSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<EnterReceiptVO> volist = new ArrayList<EnterReceiptVO>();
		ArrayList<EnterReceiptPO> polist = null;
		try {
			polist = commodityDataService.getSummitEnter();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_enter(polist.get(i)));
		return volist;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#approveEnterReceipt(java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessage approveEnterReceipt(String id) {
		// TODO Auto-generated method stub
		try {
			return commodityDataService.approveEnterReceipt(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#viewAllExitReceiptSubmitted()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<ExitReceiptVO> viewAllExitReceiptSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<ExitReceiptVO> volist = new ArrayList<ExitReceiptVO>();
		ArrayList<ExitReceiptPO> polist = null;
		try {
			polist = commodityDataService.getSummitExit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_exit(polist.get(i)));
		return volist;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#approveExitReceipt(java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ResultMessage approveExitReceipt(String id) {
		// TODO Auto-generated method stub
		try {
			return commodityDataService.approveExitReceipt(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#viewAllEnterReceipt()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<EnterReceiptVO> viewAllEnterReceipt() {
		// TODO Auto-generated method stub
		ArrayList<EnterReceiptVO> volist = new ArrayList<EnterReceiptVO>();
		ArrayList<EnterReceiptPO> polist = null;
		try {
			polist = commodityDataService.getEnterReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_enter(polist.get(i)));
		return volist;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo#viewAllExitReceipt()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:56
	 */
	@Override
	public ArrayList<ExitReceiptVO> viewAllExitReceipt() {
		// TODO Auto-generated method stub
				ArrayList<ExitReceiptVO> volist = new ArrayList<ExitReceiptVO>();
				ArrayList<ExitReceiptPO> polist = null;
				try {
					polist = commodityDataService.getExitReceipt();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<polist.size();i++)
					volist.add(Convert.po_to_vo_exit(polist.get(i)));
				return volist;
	}

    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.accountbl.Info.CommodityInfo#showAllCityInventory()
     */
	@Override
	public ArrayList<ComGoodsVO> showAllCityInventory() {
		// TODO Auto-generated method stub
		
		ArrayList<ComInfoPO> po = new ArrayList<ComInfoPO>();
		try {
			po = commodityDataService.getCommodity();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
		for(int i=0;i<po.size();i++){
			ArrayList<ComGoodsPO> polist = po.get(i).getComGoodsList();
			for(int j=0;j<polist.size();j++){
			    ComGoodsVO vo = new ComGoodsVO(Convert.po_to_vo_order(polist.get(j).getOrder()),polist.get(j).getType(),polist.get(j).getLine(),polist.get(j).getShelf(),polist.get(j).getCell());
			    volist.add(vo);
			}
		}
		
		return volist;
	}
	
	
}
