package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.po.HallTransferReceiptPO;

public class HallTransferFileDao extends CommonData<HallTransferReceiptPO> implements HallTransferDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallTransferFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String nextID(String location, String hallID) {
		// TODO Auto-generated method stub
		ArrayList<HallTransferReceiptPO> list = getAll(location);
		if(list.size()!=0){
			String num = list.get(list.size()-1).getId().substring(19, list.get(list.size()-1).getId().length());
			return "0"+(int)(Integer.parseInt(num)+1);
		}
		else
			return hallID+"0000";
	}



	@Override
	public ArrayList<HallTransferReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}


	@Override
	public ArrayList<HallTransferReceiptPO> getAll(String location) {
		// TODO Auto-generated method stub
		ArrayList<HallTransferReceiptPO> list = (showAll()==null) ? (new ArrayList<HallTransferReceiptPO>()) : showAll();

		ArrayList<HallTransferReceiptPO> newlist = new ArrayList<HallTransferReceiptPO>();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
//			System.out.println(list.size());
			if(list.get(i).getLocation().equals(location))
				newlist.add(list.get(i));
		}
		return newlist;
	}



	@Override
	public ArrayList<HallTransferReceiptPO> getAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<HallTransferReceiptPO> list = showAll();
		ArrayList<HallTransferReceiptPO> newlist = new ArrayList<HallTransferReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}



	@Override
	public void approveTransferReceipt(String id) {
		// TODO Auto-generated method stub
		HallTransferReceiptPO po = find(id);
		po.approve();
		update(id,po);
	}



	@Override
	public HallTransferReceiptPO getHallTransfer(String id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	
}
