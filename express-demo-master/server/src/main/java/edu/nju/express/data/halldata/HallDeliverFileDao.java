package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallTransferReceiptPO;

public class HallDeliverFileDao extends CommonData<DeliverReceiptPO> implements HallDeliverDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallDeliverFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nextID(String location, String hallID) {
		// TODO Auto-generated method stub
		ArrayList<DeliverReceiptPO> list = getAll(location);
		if(list.size()!=0){
			String num = list.get(list.size()-1).getId().substring(16, list.get(list.size()-1).getId().length());
			return "0"+(int)(Integer.parseInt(num)+1);
		}
		else
			return hallID+"0000";
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
        return showAll();
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAll(String location) {
		// TODO Auto-generated method stub
		ArrayList<DeliverReceiptPO> list = showAll();
		ArrayList<DeliverReceiptPO> newlist = new ArrayList<DeliverReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getLocation().equals(location))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<DeliverReceiptPO> list = showAll();
		ArrayList<DeliverReceiptPO> newlist = new ArrayList<DeliverReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public void approveDeliverReceipt(String id) {
		// TODO Auto-generated method stub
		DeliverReceiptPO po = find(id);
		po.approve();
		update(id,po);
	}

	

}
