package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.po.ArrivalReceiptPO;

public class HallArrivalFileDao extends CommonData<ArrivalReceiptPO> implements HallArrivalDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallArrivalFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nextID(String location, String hallID) {
		// TODO Auto-generated method stub
		ArrayList<ArrivalReceiptPO> list = getAll(location);
		if(list.size()!=0){
			String num = list.get(list.size()-1).getId().substring(16, list.get(list.size()-1).getId().length());
			return "0"+(int)(Integer.parseInt(num)+1);
		}
		else
			return hallID+"0000";
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAll(String location) {
		// TODO Auto-generated method stub
		ArrayList<ArrivalReceiptPO> list = showAll();
		ArrayList<ArrivalReceiptPO> newlist = new ArrayList<ArrivalReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getLocation().equals(location))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<ArrivalReceiptPO> list = showAll();
		ArrayList<ArrivalReceiptPO> newlist = new ArrayList<ArrivalReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public void approve(String id) {
		// TODO Auto-generated method stub
		ArrivalReceiptPO po = find(id);
		po.approve();
		update(id,po);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	/**
	 * 
	 */
	

}
