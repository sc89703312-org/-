package edu.nju.express.businesslogic.login;

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
	
	
	
	private static String id;
	private static String userName;
	private static String loginTime;
	private static String clientIP;
	
	private static InetAddress addr;
	private static String hostAddr;
	private static String hostName;
	
	public static void setID(String ID){
		id = ID;
	}
	
	
	public static void setUserName(String name){
		userName = name;
	}
	
	
	public static String getID(){
		return id;
	}
	
	
	public static String getUserName(){
		return userName;
	}
	
	
	public static void setTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		loginTime = sdf.format(new Date());
	}
	
	public static String getTime(){
		return loginTime;
	}
	
	
	
	
	private static String getClientIP() {
	
		try {
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return hostAddr;
	}
	
	
	public static String getInfo(){
		return "["+loginTime+"]"+" "+userName+" "+getClientIP();
	}
}
