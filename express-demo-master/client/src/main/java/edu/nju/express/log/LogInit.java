package edu.nju.express.log;

import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.ui.logmsg.LogFrame;

public class LogInit {

	public static void main(String[] s){
		RMIHelper.init();
		new LogFrame();
	}
}
