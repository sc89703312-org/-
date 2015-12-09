package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.common.GoodsState;



public class OrderPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**寄件人姓名*/
	String senderName;
	/**寄件人地址*/
	String senderAddress;
	/**寄件人单位*/
	String senderPost;
	/**寄件人电话*/
	String senderTel;
	/**寄件人手机*/
	String senderPhone;
	/**收件人姓名*/
	String receiverName;
	/**收件人地址*/
	String receiverAddress;
	/**收件人单位*/
	String receiverPost;
	/**收件人电话*/
	String receiverTel;
	/**收件人手机*/
	String receiverPhone;
	/**原件数*/
	int num;
	/**质量*/
	double weight;
	/**体积*/
	double volume;
	/**品名*/
	String goodsName;
	/**尺寸*/
	double size;
	/**包装费*/
	double pkgCost;
	/**合计*/
	double totalCost;
	/**快递类型*/
	Etype type;
	/**到达状态*/
	ArrivalState arrivalState =ArrivalState.NO;
	/**货物到达营业厅或中转中心时的保存状态*/
	GoodsState goodsState = GoodsState.COMPLETE;
	/**预计送达时间*/
	String expectedTime;
	/**当前位置信息*/
	String currentSpot;
	/**物流轨迹*/
	ArrayList<String> history;
	/**派件人*/
	String Deliver=null;
	
	public OrderPO(String sname,String saddress,String spost,String stel,String sphone,String rname,String raddress
			,String rpost,String rtel,String rphone,int num,double w,double v,String gname,double size,double pkgCost
			,double totalCost, String id,Etype t,ArrivalState arrivalState,String expectedTime,String currentSpot){
		this.senderName=sname;
		this.senderAddress=saddress;
		this.senderPost=spost;
		this.senderTel=stel;
		this.senderPhone=sphone;
		this.receiverName=rname;
		this.receiverAddress=raddress;
		this.receiverPost=rpost;
		this.receiverTel=rtel;
		this.receiverPhone=rphone;
		this.num=num;
		this.weight=w;
		this.volume=v;
		this.goodsName=gname;
		this.size=size;
		this.pkgCost=pkgCost;
		this.totalCost=totalCost;
		this.id=id;
		this.type=t;
		this.arrivalState=arrivalState;
		this.expectedTime=expectedTime;
		this.currentSpot=currentSpot;
		history = new ArrayList<String>();
		history.add(currentSpot);
	}
	
	/**
	 * 创建订单的时候要手动调用一下这个方法
	 * @param spot
	 */
	public void addHistory(String spot){
		this.history.add(spot);
	}
	
	public void setDeliver(String name){
		this.Deliver=name;
	}

	
	public void setArrivalState(ArrivalState arrivalState){
		this.arrivalState=arrivalState;
	}
	
	
	public void setCurrentSpot(String spot){
		this.currentSpot = spot;
	}
	
	public void setGoodsState(GoodsState goodsState){
		this.goodsState = goodsState;
	}

	
	public String getSenderName(){
		return this.senderName;
	}
	
	public String getSenderAddress(){
		return this.senderAddress;
	}
	
	public String getSenderPost(){
		return this.senderPost;
	}
	
	public String getSenderTel(){
		return this.senderTel;
	}
	
	public String getSenderPhone(){
		return this.senderPhone;
	}
	
	public String getReceiverName(){
		return this.receiverName;
	}
	
	public String getReceiverAddress(){
		return this.receiverAddress;
	}
	
	public String getReceiverPost(){
		return this.receiverPost;
	}
	
	public String getReceiverTel(){
		return this.receiverTel;
	}
	
	public String getReceiverPhone(){
		return this.receiverPhone;
	}
	
	
	public int getNum(){
		return this.num;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public double getVolume(){
		return this.volume;
	}
	
	public  String getGoodsName(){
		return this.goodsName;
	}
	
	public GoodsState getGoodsState(){
		return this.goodsState;
	}
	
	public double getSize(){
		return this.size;
	}
	
	public double getPkgCost(){
		return this.pkgCost;
	}
	
	public double getTotalCost(){
		return this.totalCost;
	}
	
	public String getID(){
		return this.id;
	}
	
	public Etype getType(){
		return this.type;
	}
	
	public ArrivalState getArrivalState(){
		return this.arrivalState;
	}
	
	public String getExpectedTime(){
		return this.expectedTime;
	}
	
	public String getCurrentSpot(){
		return this.currentSpot;
	}
	
	public String getDeliver(){
		return this.Deliver;
	}
	
	public ArrayList<String> viewHistory(){
		return this.history;
	}
}
