package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.ComZoneVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;



public interface CommodityBlService {
	
	public ArrayList<ArriveReceiptVO> showArriveReceiptList();
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) throws Exception;
	ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, Object[][] data);
	public void subEnterReceipt(EnterReceiptVO vo);
	
	public ArrayList<TransferReceiptVO> showTransferReceiptList();
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo);
	public void subExitReceipt(ExitReceiptVO vo);
	
	public ArrayList<ComGoodsVO> showInventory();
	public void outputInventory(ArrayList<ComGoodsVO> list);
	public int[] showCheck(String start, String end);
	public ArrayList<EnterReceiptVO> showCheckEnter(String start,String end);
	public ArrayList<ExitReceiptVO> showCheckExit(String start,String end);
	
	public ComZoneVO showZone();
	public ResultMessageV2 editZone(int[] space);
	public ResultMessageV2 initZone();
	public ResultMessageV2 moveGoods(Object data[][]);

	
}
