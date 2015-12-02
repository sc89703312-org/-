package edu.nju.express.init;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.log.LogController;
import edu.nju.express.log.ui.logmsg.LogFrame;
import edu.nju.express.po.BankingAccountPO;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.Paymentvo;






public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
       
		

//		try {
//			RMIHelper.getBankingDataService().insert(new BankingAccountPO("sc"));
//			RMIHelper.getBankingDataService().insert(new BankingAccountPO("a"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println(RMIHelper.getBankingDataService().getAccount()
//					.get(0).getId());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Bankingbl bankingbl = new Bankingbl();
//		bankingbl.addAccount("sc");
//		bankingbl.addAccount("a");

		ArrayList<BankingAccountVO> bankingAccountVOs = bankingbl.getAllAccounts();
		for(BankingAccountVO vo:bankingAccountVOs)
			System.out.println(vo.getName()+" "+vo.getMoney());
		
//		
//		try {
//			System.out.println(RMIHelper.getBankingDataService().getAccount().get(0).getName());;
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Paymentbl paymentbl = new Paymentbl(bankingbl);
//	    System.out.println
//	    (paymentbl.createReceipt(
//	    		new Paymentvo("2015-12-2", 600, "025000001", "0000000001", "sc")));	
//		
//		new LoginUI();
		

//		new LogFrame();
//		System.out.println(LogController.getLogsByDate("2015-12-01").get(0).getDate());
	}
}