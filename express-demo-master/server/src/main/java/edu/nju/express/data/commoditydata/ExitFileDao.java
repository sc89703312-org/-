package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ExitReceiptPO;

public class ExitFileDao extends CommonData<ExitReceiptPO> implements ExitReceiptDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExitFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void add(ExitReceiptPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

	@Override
	public ArrayList<ExitReceiptPO> showAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	@Override
	public ArrayList<ExitReceiptPO> showAllReceipt(String comID) {
		// TODO Auto-generated method stub
		ArrayList<ExitReceiptPO> list = showAll();
		ArrayList<ExitReceiptPO> newlist = new ArrayList<ExitReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getId().contains(comID))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<ExitReceiptPO> showAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<ExitReceiptPO> list = this.showAll();
		ArrayList<ExitReceiptPO> newlist = new ArrayList<ExitReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		ExitReceiptPO po = find(id);
		po.approve();
		return update(id,po);
	}

	@Override
	public String nextID(String comID) {
		// TODO Auto-generated method stub
		ArrayList<ExitReceiptPO> list = showAllReceipt(comID);
		String id = list.get(list.size()-1).getId();
		String nextID = Integer.parseInt(id.substring(12, id.length()))+1+"";
		return nextID;
	}

	
	
}
