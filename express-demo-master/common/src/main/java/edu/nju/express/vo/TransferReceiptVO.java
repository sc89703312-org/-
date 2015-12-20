package edu.nju.express.vo;

import java.util.ArrayList;

import edu.nju.express.common.Etype;

/**
 * 中转单
 * 中转单包含装车日期、本中转中心中转单编号
 * （中转中心编号+日期+0000000七位数字），
 * 航班号、出发地、到达地、货柜号、监装员、
 * 本次装箱所有托运单号、运费（运费根据出发地
 * 和目的地自动生成）
 */


public class TransferReceiptVO extends ReceiptVOBase{
	
	String to;
	String location;
	String transportID;
	String supervisor;
	double cost;
	Etype etype;
	
	ArrayList<OrderVO> orderList;
    
    public TransferReceiptVO(String id, String date, String to, String location, String transportID, String supervisor, Etype etype, ArrayList<OrderVO> list){
		
		this.id =id;
		this.date = date;
		this.to = to;
		this.location = location;
		this.transportID = transportID;
		this.supervisor = supervisor;
		this.etype = etype;
		
		orderList = list;
		
	}
    
    public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTo(){
		return this.to;
	}
	
	public String getLocation(){
		return this.location;
	}

    public ArrayList<OrderVO> getList(){
    	return this.orderList;
    }
    
	public String getTransportID(){
		return this.transportID;
	}
    
    public String getSupervisor(){
    	return this.supervisor;
    }
    
    public Etype getType(){
    	return this.etype;
    }
    
    public double getCost(){
    	return this.cost;
    }
	
}
