package edu.nju.express.po;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private  String id;
	private  static String userName;
	private  static String userID;
	private  String name;
	private  String loginTime;
	private  String clientIP;
	
	private  InetAddress addr;
	private  String hostAddr;

	
	
	
	public LoginInfo(String id,String userName) {
		// TODO Auto-generated constructor stub

		this.id = id;
        this.name = userName;
		setTime();
	}
	
	
	public static void setUserName(String name){
		LoginInfo.userName = name;
	}
	
	public static void setUserID(String ID){
		LoginInfo.userID = ID;
	}
	
	public static String getUserName(){
		return userName;
	}
	
	public static String getUserID(){
		return userID;
	}
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public String getTime(){
		return loginTime;
	}
	
	public void setTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		loginTime = sdf.format(new Date()).split(" ")[1];
	}
	
	
	
	
	public  void setClientIP(){
		clientIP =getClientIP();
	}
	
	
	public  String getClientIP() {
	
		try {
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return hostAddr;
	}
	
	
	public  String getInfo(){
		return "["+loginTime+"]"+" "+name+" "+id+" "+getClientIP();
	}
}
