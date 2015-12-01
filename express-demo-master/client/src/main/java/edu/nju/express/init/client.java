package edu.nju.express.init;

import edu.nju.express.log.LogController;
import edu.nju.express.log.ui.logmsg.LogFrame;
import edu.nju.express.po.LogMessage;
import edu.nju.express.presentation.loginui.LoginUI;






public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
	
		new LogFrame();
		
		
//		LogController.insertLog(new LogMessage("结算管理 记录公司日前为止的总收入总支出", "Echo_佳小兔"));

//		System.out.println(LogController.getLogsByDate("2015-12-01").get(0).getDate());
	}
}