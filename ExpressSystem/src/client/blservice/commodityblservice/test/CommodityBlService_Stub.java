package client.blservice.commodityblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.commodityblservice.CommodityBlService;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.Etype;
import client.vo.commodityvo.ComGoodsVO;
import client.vo.commodityvo.ComZoneVO;
import client.vo.commodityvo.EnterReceiptVO;
import client.vo.commodityvo.ExitReceiptVO;
import client.vo.stationvo.ArriveReceiptVO;
import client.vo.stationvo.TransferReceiptVO;
import client.vo.ordervo.OrderVO;

public class CommodityBlService_Stub implements CommodityBlService{
	
	//入库管理部分
	public ArrayList<ArriveReceiptVO> showArriveReceiptList(){
		
		ArrayList<ArriveReceiptVO> list = new ArrayList<ArriveReceiptVO>();
		list.add(new ArriveReceiptVO("100","2015/10/25","Shanghai","Nanjing",new ArrayList<OrderVO>()));
		return list;
		
	}
	
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo){
		
		EnterReceiptVO enterReceipt = new EnterReceiptVO(new ArrayList<ComGoodsVO>(), "300", "2015/10/25", "Nanjing");
		return enterReceipt;
		
	}
	
	public ResultMessage editEnterReceipt(EnterReceiptVO vo, String orderID){
		
		ResultMessage result;
		
		if(orderID=="300")
			result = ResultMessage.VALID;
		else
			result = ResultMessage.INVALID;
		
		return result;
		
	}
	
	public void subEnterReceipt(EnterReceiptVO vo){
		
		System.out.println("submit sucessfully!");
		
	}
	
	//出库管理部分
	public ArrayList<TransferReceiptVO> showTransferReceipt(){
		
		ArrayList<TransferReceiptVO> list = new ArrayList<TransferReceiptVO>();
		list.add(new TransferReceiptVO("100","2015/10/25","Nanjing","Shanghai",new ArrayList<OrderVO>()));
		return list;
		
	}
	
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo){
		
		ExitReceiptVO exitReceipt = new ExitReceiptVO(new ArrayList<ComGoodsVO>(), "300", "2015/10/25", "Nanjing");
		return exitReceipt;
		
	}
	
	public void subExitReceipt(ExitReceiptVO vo){
		
		System.out.println("submit sucessfully!");
		
	}
	
	//库存盘点与查看部分
	public ArrayList<ComGoodsVO> showInventory(){
		
		ArrayList<ComGoodsVO> goods_list = new ArrayList<ComGoodsVO>();
		goods_list.add(new ComGoodsVO(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing"), "Train-A-23"));
		
		return goods_list;
		
	}
	
	public void outputInventory(ArrayList<ComGoodsVO> list){
		
		System.out.println("output successfully!");
		
	}
	
	public int[] showCheck(String start, String end){
		
		int enterNum = 10;
		int exitNum = 8;
		int enterMoney = 1000;
		int exitMoney = 800;
		
		int[] result = new int[4];
		result[0] = enterNum;
		result[1] = exitNum;
		result[2] = enterMoney;
		result[3] = exitMoney;
		
		return result;
		
	}
	
    //库存初始化与调整部分
	public ComZoneVO showZone(){
		
		int[] space = {10,10,10,10};
		ComZoneVO comZone = new ComZoneVO(space);
		return comZone;
		
	}
	
	public ResultMessage editZone(ComZoneVO vo, int[] space){
		
		ResultMessage result;
		result = ResultMessage.VALID;
		return result;
		
	}
	
	public void subZone(ComZoneVO vo){
		
		System.out.println("submit successfully!");
		
	}
	
}
