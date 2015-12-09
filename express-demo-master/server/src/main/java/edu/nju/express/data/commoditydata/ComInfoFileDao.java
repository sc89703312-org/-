package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;

public class ComInfoFileDao extends CommonData<ComInfoPO> implements ComInfoDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComInfoFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(ComInfoPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

	@Override
	public void remove(String comID) {
		// TODO Auto-generated method stub
		delete(comID);
	}

	@Override
	public void modify(String comID, ComInfoPO po) {
		// TODO Auto-generated method stub
		update(comID,po);
	}

	@Override
	public String nextID() {
		// TODO Auto-generated method stub
		ArrayList<ComInfoPO> list = this.showAll();
		String id = list.get(list.size()-1).getId();
		return id+1+"";
	}

	@Override
	public void addGoods(String comID, ArrayList<ComGoodsPO> list) {
		// TODO Auto-generated method stub
		ComInfoPO po = this.find(comID);
		ArrayList<ComGoodsPO> clist = po.getComGoodsList();
		clist.addAll(list);
		
		ComZonePO zone = po.getZone();
		int shelfPerLine = zone.getShelfPerLine();
		int cellPerShelf = zone.getCellPerShelf();
		for(int i=0;i<list.size();i++){
			int index = (list.get(i).getLine()-1)*shelfPerLine*cellPerShelf + (list.get(i).getShelf()-1)*cellPerShelf + list.get(i).getCell() - 1;
			switch(list.get(i).getType()){
			case 1: zone.getIsEmptyPlane()[index] = false;break;
			case 2: zone.getIsEmptyTrain()[index] = false;break;
			case 3: zone.getIsEmptyCar()[index] = false;break;
			case 4: zone.getIsEmptyTem()[index] = false;break;
			}
		}
		this.update(comID, po);
	}

	@Override
	public void removeGoods(String comID, ArrayList<ComGoodsPO> list) {
		// TODO Auto-generated method stub
		ComInfoPO po = this.find(comID);
		ArrayList<ComGoodsPO> clist = po.getComGoodsList();
		for(int i=0;i<clist.size();i++)
			for(int j=0;j<list.size();j++)
				if(clist.get(i).id.equals(list.get(j).getId())){
					clist.remove(i);
					list.remove(j);
					i--;
					break;
				}
		
		ComZonePO zone = po.getZone();
		int shelfPerLine = zone.getShelfPerLine();
		int cellPerShelf = zone.getCellPerShelf();
		for(int i=0;i<list.size();i++){
			int index = (list.get(i).getLine()-1)*shelfPerLine*cellPerShelf + (list.get(i).getShelf()-1)*cellPerShelf + list.get(i).getCell() - 1;
			switch(list.get(i).getType()){
			case 1: zone.getIsEmptyPlane()[index] = true;break;
			case 2: zone.getIsEmptyTrain()[index] = true;break;
			case 3: zone.getIsEmptyCar()[index] = true;break;
			case 4: zone.getIsEmptyTem()[index] = true;break;
			}
		}
		
		update(comID,po);
	}

}
