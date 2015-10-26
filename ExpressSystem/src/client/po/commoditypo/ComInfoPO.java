package client.po.commoditypo;

import java.util.ArrayList;

public class ComInfoPO {

	String comID;
	String location;
	ArrayList<ComGoodsPO> goods_list;
	ArrayList<EnterReceiptPO> enter_list;
	ArrayList<ExitReceiptPO> exit_list;
	
	int planeSpace;
	int trainSpace;
	int carSpace;
	int temSpace;
	
	int planeSpaceGoods;
	int trainSpaceGoods;
	int carSpaceGoods;
	int temSpaceGoods;
	
	public ComInfoPO(String comID, String location){
		this.comID = comID;
		this.location = location;
		
		goods_list = new ArrayList<ComGoodsPO>();
		enter_list = new ArrayList<EnterReceiptPO>();
		exit_list = new ArrayList<ExitReceiptPO>();
		
		planeSpace = 0;
		trainSpace = 0;
		carSpace = 0;
		temSpace = 0;
		
		planeSpaceGoods = 0;
		trainSpaceGoods = 0;
		carSpaceGoods = 0;
		temSpaceGoods = 0;
		
	}
	
	public void addComGoodsPO(ComGoodsPO po){
		goods_list.add(po);
	}
	
	public void removeComGoodsPO(ComGoodsPO po){
		goods_list.remove(po);
	}
	
	public void addEnterReceiptPO(EnterReceiptPO po){
		enter_list.add(po);
	}
	
	public void addExitReceiptPO(ExitReceiptPO po){
		exit_list.add(po);
	}
	
	public ArrayList<ComGoodsPO> getComGoodsList(){
		return goods_list;
	}
	
	public ArrayList<EnterReceiptPO> getEnterList(){
		return enter_list;
	}
	
	public ArrayList<ExitReceiptPO> getExitList(){
		return exit_list;
	}
	
	public int getPlaneSpace(){
		return planeSpace;
	}
	
	public int getTrainSpace(){
		return trainSpace;
	}
	
	public int getCarSpace(){
		return carSpace;
	}
	
	public int getTemSpace(){
		return temSpace;
	}
	
	public int getPlaneSpaceGoods(){
		return planeSpaceGoods;
	}
	
	public int getTrainSpaceGoods(){
		return trainSpaceGoods;
	}
	
	public int getCarSpaceGoods(){
		return carSpaceGoods;
	}
	
	public int getTemSpaceGoods(){
		return temSpaceGoods;
	}
	
	public void modifyPlaneSpace(int space){
		planeSpace = space;
	}
	
	public void modifyTrainSpace(int space){
		trainSpace = space;
	}
	
	public void modifyCarSpace(int space){
		carSpace = space;
	}
	
	public void modifyTemSpace(int space){
		temSpace = space;
	}
	
}
