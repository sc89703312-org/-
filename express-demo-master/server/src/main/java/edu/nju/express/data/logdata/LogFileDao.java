package edu.nju.express.data.logdata;

import java.util.ArrayList;

import edu.nju.express.loglist.LogList;
import edu.nju.express.po.LogMessage;

public class LogFileDao  implements LogDao {

	

	public LogList<LogMessage> logs;
	String path;
	
	
	public LogFileDao(String path) {
		// TODO Auto-generated constructor stub
		logs = new LogList<LogMessage>(path);
	}
	
	
	

	@Override
	public void insertLog(LogMessage msg) {
		// TODO Auto-generated method stub
		logs.insert(msg);
	}

	@Override
	public ArrayList<LogMessage> viewAllLogs() {
		// TODO Auto-generated method stub
		return logs.showAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		logs.flush();
	}




	@Override
	public ArrayList<LogMessage> viewLogsByDate(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<LogMessage> curLogs = new ArrayList<>();
		
		for(int i=0;i<logs.showAll().size();i++){
			if(logs.showAll().get(i).getDate().equals(date))
				curLogs.add(logs.showAll().get(i));
		}
		
		
		return curLogs;
	}

}
