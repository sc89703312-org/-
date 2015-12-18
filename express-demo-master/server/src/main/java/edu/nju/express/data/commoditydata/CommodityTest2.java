package edu.nju.express.data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataimpl.CommodityDataService_Impl;
import edu.nju.express.dataimpl.HallDataService_Impl;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.HallTransferReceiptPO;

public class CommodityTest2 {

	public static void main(String[] args){
		try {
			CommodityDataService_Impl impl = new CommodityDataService_Impl();
            ArrayList<ComInfoPO> list = impl.getCommodity();
            for(int i=0;i<list.size();i++)
            	System.out.println(list.get(i).id);
			impl.flush();
			
//		    HallDataService_Impl impl = new HallDataService_Impl();
//		    ArrayList<HallTransferReceiptPO> list = impl.getAllHallTransfer();
//		    System.out.println(list.get(0).getLocation());
//		    ArrayList<HallPo> halllist = impl.showHall();
//		    for(int i=0;i<halllist.size();i++)
//		    	if(halllist.get(i).id.equals("025001"))
//		    		System.out.println(halllist.get(i).getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
