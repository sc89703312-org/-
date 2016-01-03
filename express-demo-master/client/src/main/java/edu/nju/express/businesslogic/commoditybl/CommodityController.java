package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.ComZoneVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public class CommodityController implements CommodityBlService{

	private CommodityBlService commodityBL;
	private static CommodityController instance;
	
	private CommodityController() {
		// TODO Auto-generated constructor stub
	
		commodityBL = DataFactory.createCommodityBlInstance();
	
	}
	
	public static CommodityController getInstance()
	{
		return instance = (instance==null)?new CommodityController():instance;
	}
	
	@Override
	public ArrayList<ArriveReceiptVO> showArriveReceiptList() {
		// TODO Auto-generated method stub
		return commodityBL.showArriveReceiptList();
	}

	@Override
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) throws Exception {
		// TODO Auto-generated method stub
		return commodityBL.showEnterReceipt(vo);
	}

	@Override
	public ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, Object[][] data) {
		// TODO Auto-generated method stub
		return commodityBL.editEnterReceipt(vo, data);
	}

	@Override
	public void subEnterReceipt(EnterReceiptVO vo) {
		// TODO Auto-generated method stub
		commodityBL.subEnterReceipt(vo);
	}

	@Override
	public ArrayList<TransferReceiptVO> showTransferReceiptList() {
		// TODO Auto-generated method stub
		return commodityBL.showTransferReceiptList();
	}

	@Override
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		return commodityBL.showExitReceipt(vo);
	}

	@Override
	public void subExitReceipt(ExitReceiptVO vo) {
		// TODO Auto-generated method stub
		commodityBL.subExitReceipt(vo);
	}

	@Override
	public ArrayList<ComGoodsVO> showInventory() {
		// TODO Auto-generated method stub
		return commodityBL.showInventory();
	}

	@Override
	public void outputInventory(ArrayList<ComGoodsVO> list) {
		// TODO Auto-generated method stub
		commodityBL.outputInventory(list);
	}

	@Override
	public int[] showCheck(String start, String end) {
		// TODO Auto-generated method stub
		return commodityBL.showCheck(start, end);
	}

	@Override
	public ArrayList<EnterReceiptVO> showCheckEnter(String start, String end) {
		// TODO Auto-generated method stub
		return commodityBL.showCheckEnter(start, end);
	}

	@Override
	public ArrayList<ExitReceiptVO> showCheckExit(String start, String end) {
		// TODO Auto-generated method stub
		return commodityBL.showCheckExit(start, end);
	}

	@Override
	public ComZoneVO showZone() {
		// TODO Auto-generated method stub
		return commodityBL.showZone();
	}

	@Override
	public ResultMessageV2 editZone(int[] space) {
		// TODO Auto-generated method stub
		return commodityBL.editZone(space);
	}

	@Override
	public ResultMessageV2 initZone() {
		// TODO Auto-generated method stub
		return commodityBL.initZone();
	}

	@Override
	public ResultMessageV2 moveGoods(Object[][] data) {
		// TODO Auto-generated method stub
		return commodityBL.moveGoods(data);
	}

}
