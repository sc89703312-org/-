package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;

public interface ComInfoDao {

	public void add(ComInfoPO po);
	public void remove(String comID);
	public void modify(String comID, ComInfoPO po);
	public ComInfoPO find(String comID);
	public ArrayList<ComInfoPO> getAll();
	//public void modifyZone(ComZonePO po);
	public String nextID();
	
	public void addGoods(String comID, ArrayList<ComGoodsPO> list);
	public void removeGoods(String comID, ArrayList<ComGoodsPO> list);
	
}
