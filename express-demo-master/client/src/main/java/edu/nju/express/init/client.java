package edu.nju.express.init;

import java.rmi.RemoteException;

import edu.nju.express.common.Item;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.po.Balancepo;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.po.UserPO;
import edu.nju.express.presentation.loginui.LoginUI;







public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		
//		
//		new LoginUI();
		

		
		try {
			System.out.println(RMIHelper.getUserMessageDataService().insert(new UserMessagePO(StaffChange.add, "sc"," a", Role.ACCOUNTANT)));;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

//		try {
//			System.out.println(RMIHelper.getPaymentDataService().getAll().size());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			RMIHelper.getPaymentDataService().update("0000000003",
//					new Paymentpo("2000/1/1", 1, "025000123", "0000000003", "aaaa"));;
//		
//		
//		
//					System.out.println(RMIHelper.getPaymentDataService().find("0000000003").getBankaccount()
//		);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		
//		try {
//			RMIHelper.getPaymentDataService().insert(
//					new Paymentpo("2015/11/22", 200, "025000001", "0000000008", "sc"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		try {
//			RMIHelper.getBalanceDataService().insert
//			(new Balancepo("2015/11/22", 2000,
//					"DSY", "SC", Item.BONUS, "2000"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	
//		
//		try {
//			RMIHelper.getVehicleDataService().deleteDri("025000");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		try {
//			RMIHelper.getPaymentDataService().insert
//			(new Paymentpo("2015/11/22",200 , "02500001", "0000000001", "sc"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		
//		try {
//		RMIHelper.getPaymentDataService().delete("2015/11/22 0000000001");;
//		
//				} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		try {
//			RMIHelper.getVehicleDataService().insertCar
//			(new Carpo("025000", "a", "Sua", "b", "2011/1/1", 6));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			RMIHelper.getVehicleDataService().insertDri
//			(new Driverpo("025000", "a", "a", "a", "a", "a", true, "a"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
//		try {
//			RMIHelper.getVehicleDataService().deleteDri("025000");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			ArrayList<Paymentpo> arrayList=RMIHelper.getPaymentDataService().viewByDate("2015/11/22");
//			
//			for(int i=0;i<arrayList.size();i++){
//				System.out.println(arrayList.get(i).getCourier_id());
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		

		
		
//		try {
//			
//			ArrayList<Paymentpo> temp =RMIHelper.getPaymentDataService().viewByDate("2015/9/12");
//		
//			for(int i=0;i<temp.size();i++){
//				System.out.println(temp.get(i).getId());
//			}
//		
//		
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	
		
		
//		try {
//			RMIHelper.getVehicleDataService().insertDri(new Driverpo(025000001, "ttt",
//															 "1996/1/3", "321283",
//															 "89703312", "025000",
//															 true, "2016/1/2"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
//  	try {
//			RMIHelper.getPaymentDataService().insert(new Paymentpo("2011/6/7",
//				                                                      20, "0251234567",
//				                                                      "0000000001", "aaa"));
	//	
//		ArrayList<Paymentpo> temp = RMIHelper.getPaymentDataService().getAll();
//		for(int i=0;i<temp.size();i++){
//		System.out.println(new Paymentvo(temp.get(i).getDate(),temp.get(i).getPay(),
//					              temp.get(i).getCourier_id(),temp.get(i).getOrder_id(),
//			              temp.get(i).getBankaccount()).toString());
			
//					System.out.println();
//		}
			
//			RMIHelper.getVehicleDataService().insertCar(new Carpo(02500020, "motor-1",
//					                                                 "Su-A 8908", "base-1", 
//					                                                 "2016/1/1", 1));
//		
//			
//			
	
		
		
//		
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
//	paymentui ui = new paymentui();
	
//		
//		try {
//			RMIHelper.getVehicleDataService().findCar(02500020);
			
//			RMIHelper.getVehicleDataService().deleteCar(RMIHelper.getVehicleDataService().findCar(02500021));
			
//		RMIHelper.getVehicleDataService().insertCar(new Carpo(02500022, "motor-1",
//            "Su-A 0523", "base-1", 
//            "2016/1/3", 1));
			
//			RMIHelper.getVehicleDataService().findCar(02500021);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("error");
//			e.printStackTrace();
//		}
		
		
	}
}