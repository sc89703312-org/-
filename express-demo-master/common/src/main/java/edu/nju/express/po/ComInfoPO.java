package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class ComInfoPO extends PersistentObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String comID;
	String location;
	ArrayList<ComGoodsPO> goods_list;
	
	ComZonePO zonePO;
	
	public ComInfoPO(String comID, String location, int totalSpace){
		
		this.comID = comID;
		this.location = location;
		this.id = comID;
		this.date = "";
		
		goods_list = new ArrayList<ComGoodsPO>();
		zonePO = new ComZonePO(totalSpace);
		
	}
	
	public void addComGoodsPO(ComGoodsPO po){
		goods_list.add(po);
	}
	
	public void removeComGoodsPO(ComGoodsPO po){
		goods_list.remove(po);
	}
	
	public ArrayList<ComGoodsPO> getComGoodsList(){
		return goods_list;
	}
	
	public ComZonePO getZone(){
		return this.zonePO;
	}
	
}
