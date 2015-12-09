package edu.nju.express.data.commoditydata;

import java.rmi.RemoteException;

import edu.nju.express.dataimpl.CommodityDataService_Impl;

public class CommodityTest2 {

	public static void main(String[] args){
		try {
			CommodityDataService_Impl impl = new CommodityDataService_Impl();
			impl.addCommodity("025", "南京", 1000);
			impl.flush();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
