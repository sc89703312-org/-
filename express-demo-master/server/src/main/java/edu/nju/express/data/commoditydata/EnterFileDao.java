package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.EnterReceiptPO;

public class EnterFileDao extends CommonData<EnterReceiptPO> implements EnterReceiptDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnterFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(EnterReceiptPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}
	
	@Override
	public ArrayList<EnterReceiptPO> showAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	@Override
	public ArrayList<EnterReceiptPO> showAllReceipt(String comID) {
		// TODO Auto-generated method stub
		ArrayList<EnterReceiptPO> list = showAll();
		ArrayList<EnterReceiptPO> newlist = new ArrayList<EnterReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getId().contains(comID))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<EnterReceiptPO> showAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<EnterReceiptPO> list = this.showAll();
		ArrayList<EnterReceiptPO> newlist = new ArrayList<EnterReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		EnterReceiptPO po = find(id);
		po.approve();
		return update(id,po);
	}

	@Override
	public String nextID(String comID) {
		// TODO Auto-generated method stub
		ArrayList<EnterReceiptPO> list = showAllReceipt(comID);
		String nextID;
		if(list.size()!=0){
		    String id = list.get(list.size()-1).getId();
		    nextID = Integer.parseInt(id.substring(12, id.length()))+1+"";
		}
		else
		    nextID = comID+"200000";
		return nextID;
	}

}
