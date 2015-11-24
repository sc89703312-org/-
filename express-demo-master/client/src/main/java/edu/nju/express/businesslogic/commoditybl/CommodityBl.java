package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.ComZoneVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public class CommodityBl implements CommodityBlService{
	
	StationInfo stationInfo;
	
	public CommodityBl(StationInfo stationInfo){
		this.stationInfo = stationInfo;
	}

	@Override
	public ArrayList<ArriveReceiptVO> showArriveReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveArrive();
	}

	@Override
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage editEnterReceipt(EnterReceiptVO vo, String orderID) {
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
