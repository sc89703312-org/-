package client.vo.ordervo;

import java.io.Serializable;



public class OrderVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String senderName;
	String senderAddress;
	String senderPost;
	String senderTel;
	String senderPhone;
	String receiverName;
	String receiverAddress;
	String receiverPost;
	String receiverTel;
	String receiverPhone;
	int num;
	double weight;
	double volume;
	String goodsName;
	double size;
	double pkgCost;
	double totalCost;
	String id;
	Etype type;
	ArrivalState arrivalState;

	public OrderVO(String sname,String saddress,String spost,String stel,String sphone,String rname,String raddress
			,String rpost,String rtel,String rphone,int num,double w,double v,String gname,double size,double pkgCost
			,double totalCost, String id,Etype t,ArrivalState arrivalState){
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

	public ArrivalState getState(){
		return this.arrivalState;
	}
}
