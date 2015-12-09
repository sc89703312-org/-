package edu.nju.express.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LogMessage extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** 操作时间 */
	public String time;
	/** 操作员 */
	public String username;
	/** 操作信息 */
	public String message;
	

	

	
	
	public LogMessage(String message,String userName) {
		// TODO Auto-generated constructor stub
	
	this.username = userName;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.time = sdf.format(new Date());
	
	this.message = message;
	
	this.id      = sdf.format(new Date());
	
	this.date = id.substring(0,10);
	}
	
	
	
	@Override
    public String getDate() {
		
		return this.date;
		
	};
	
	
	@Override
	public String getId(){
		return this.id;
	}
	
	
	public String toString() {
		return "[" + this.id + "] [" + this.username + "] " + this.message;
	}
}
