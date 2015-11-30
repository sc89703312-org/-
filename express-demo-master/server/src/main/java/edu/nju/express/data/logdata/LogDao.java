package edu.nju.express.data.logdata;

import java.util.ArrayList;

import edu.nju.express.po.LogMessage;

public interface LogDao {

	
	public void insertLog(LogMessage msg);
	
	public ArrayList<LogMessage> viewAllLogs();
	
	public void flush();
}
