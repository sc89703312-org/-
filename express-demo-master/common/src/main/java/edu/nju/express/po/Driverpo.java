package edu.nju.express.po;

import java.io.Serializable;


public class Driverpo extends PersistentObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 司机姓名 */
	String name;
	
	/**出生日期 */
	String birthdate;
	
	/**身份证号 */
	String certificate;
	
	/**手机号码 */
	String phone;
	
	/**所属营业厅编号*/
	String hall_id;
	
	/**性别 */
	boolean sex;
	
	/**使用期限*/
	String ddl;
	
	
	public Driverpo(String id,String n,String b,String c,String p,String h,boolean s,String d) {
		// TODO Auto-generated constructor stub
      
		this.id  = id;
		name = n;
		birthdate = b;
		certificate = c;
		phone = p;
		hall_id = h;
		sex = s;
		ddl = d;
	
	
	}

	
	
	
	public String getName(){
		return name;
	}
	
	public String getBirthDate(){
		return birthdate;
	}
	
	public String getCertificate(){
		return certificate;
	}
	
	public String getPhone(){
		return phone;
	}
	
	
	public String getHallId(){
		return hall_id;
	}
	
	
	public boolean getSex(){
		return sex;
	}
	
	public String getDdl(){
		return ddl;
	}
}
