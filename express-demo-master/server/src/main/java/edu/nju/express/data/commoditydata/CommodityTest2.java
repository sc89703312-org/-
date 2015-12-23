package edu.nju.express.data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.data.stationdata.StationFileDao;
import edu.nju.express.dataimpl.CommodityDataService_Impl;
import edu.nju.express.dataimpl.HallDataService_Impl;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.HallTransferReceiptPO;

public class CommodityTest2 {

	public static void main(String[] args){

			
			StationFileDao dao = new StationFileDao("station");
			dao.rename("010", "北京中转站");
			dao.rename("020", "广州中转站");
			dao.rename("021", "上海中转站");
			dao.rename("025", "南京中转站");
			dao.flush();
	}
			
			
}
	

