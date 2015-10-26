package client.blservice.commodityblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.commodityblservice.CommodityBlService;
import client.vo.commodityvo.ComGoodsVO;
import client.vo.commodityvo.ComZoneVO;
import client.vo.commodityvo.EnterReceiptVO;
import client.vo.commodityvo.ExitReceiptVO;
import client.vo.stationvo.ArriveReceiptVO;
import client.vo.stationvo.TransferReceiptVO;


public class CommodityBlService_Driver {

	public void driver(CommodityBlService service){
		
		ArrayList<ArriveReceiptVO> arrive_list = service.showArriveReceiptList();
		ArriveReceiptVO arriveReceipt = arrive_list.get(0);
		System.out.println("the first receipt in arrive_list is id:"+arriveReceipt.getID()+" date:"+arriveReceipt.getDate()
				+" from:"+arriveReceipt.getFrom()+" location:"+arriveReceipt.getLocation());
		
		EnterReceiptVO enterReceipt = service.showEnterReceipt(arriveReceipt);
		System.out.println("the enterReceipt is id:"+enterReceipt.getID()+" date:"+enterReceipt.getDate()+
				" location:"+enterReceipt.getLocation());
		
		ResultMessage result = service.editEnterReceipt(enterReceipt, "300");
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
		service.subEnterReceipt(enterReceipt);
		
		ArrayList<TransferReceiptVO> transfer_list = service.showTransferReceipt();
		TransferReceiptVO transferReceipt = transfer_list.get(0);
		System.out.println("the first receipt in transfer_list is id:"+transferReceipt.getID()+" date:"+transferReceipt.getDate()
				+" from:"+transferReceipt.getTo()+" location:"+transferReceipt.getLocation());
		
		ExitReceiptVO exitReceipt = service.showExitReceipt(transferReceipt);
		System.out.println("the enterReceipt is id:"+exitReceipt.getID()+" date:"+exitReceipt.getDate()+
				" location:"+exitReceipt.getLocation());
		
		service.subExitReceipt(exitReceipt);
		
		ArrayList<ComGoodsVO> goods_list = service.showInventory();
		ComGoodsVO goods = goods_list.get(0);
		System.out.println("the goods " + goods.getOrder().getID()+" is at "+goods.getComLocation());
		
		service.outputInventory(goods_list);
		
		int[] nums = service.showCheck("2015/10/23", "2015/10/25");
		System.out.println("entergoods: "+nums[0]+" exitgoods: "+nums[1]+" entermoney: "+nums[2]+" exitmoney: "+nums[3]);
		
		ComZoneVO comZone = service.showZone();
		System.out.println("planespace:"+comZone.getSpace()[0]);
		System.out.println("trainspace:"+comZone.getSpace()[1]);
		System.out.println("carspace:"+comZone.getSpace()[2]);
		System.out.println("temspace:"+comZone.getSpace()[3]);
		
		result = service.editZone(comZone,new int[] {12,8,10,10});
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
		service.subZone(comZone);
		
	}
	
	public static void main(String[] args){
		CommodityBlService_Driver driver = new CommodityBlService_Driver();
		driver.driver(new CommodityBlService_Stub());
	}
	
}
