package client.main;


import java.rmi.RemoteException;




public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
	

		
		
//		try {
//			RMIHelper.getPaymentDataService().delete("2014/9/11 1234567890");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			
//			ArrayList<Paymentpo> temp =RMIHelper.getPaymentDataService().viewByDate("2014/1/3");
//		
//			for(int i=0;i<temp.size();i++){
//				System.out.println(temp.get(i).getId());
//			}
//		
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

//		try {
//			System.out.println(RMIHelper.getPaymentDataService().find("0000000001").getCourier_id().substring(0, 6));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		try {
//			RMIHelper.getVehicleDataService().insertDri(new Driverpo(025000001, "XiaoLiu",
//															 "1996/1/3", "321283",
//															 "89703312", "025000",
//															 true, "2016/1/2"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//  	try {
//			RMIHelper.getPaymentDataService().insert(new Paymentpo("2015/9/12",
//				                                                      20, "025000000",
//				                                                      "0000000001", "sc89703312"));
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
