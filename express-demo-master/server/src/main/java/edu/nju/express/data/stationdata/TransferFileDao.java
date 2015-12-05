package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.TransferReceiptPO;

public class TransferFileDao extends CommonData<TransferReceiptPO> implements TransferReceiptDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(TransferReceiptPO po) {
		// TODO Auto-generated method stub
		return insert(po);
	}

	@Override
	public String getNextID(String stationID,String location) {
		// TODO Auto-generated method stub
		ArrayList<TransferReceiptPO> list = getAllReceipt(location);
		if(list.size()!=0){
			TransferReceiptPO po = list.get(list.size()-1);
			return Integer.parseInt(po.getId().substring(15, po.getId().length()))+1+"";
		}
		else
			return stationID+"0000";
	}

	@Override
	public ArrayList<TransferReceiptPO> getAllReceipt(String location) {
		// TODO Auto-generated method stub
		ArrayList<TransferReceiptPO> list = getAllReceipt();
		ArrayList<TransferReceiptPO> newlist = new ArrayList<TransferReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getLocation().equals(location))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<TransferReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	@Override
	public ArrayList<TransferReceiptPO> getSummitTransfer() {
		// TODO Auto-generated method stub
		ArrayList<TransferReceiptPO> list = showAll();
		ArrayList<TransferReceiptPO> newlist = new ArrayList<TransferReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<TransferReceiptPO> getApproveTransfer(String stationID) {
		// TODO Auto-generated method stub
		ArrayList<TransferReceiptPO> list = showAll();
		ArrayList<TransferReceiptPO> newlist = new ArrayList<TransferReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.APPROVED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		TransferReceiptPO po = find(id);
		po.approve();
		update(id,po);
		return null;
	}

	@Override
	public TransferReceiptPO getTransfer(String id) {
		// TODO Auto-generated method stub
		return find(id);
	}
	
	@Override
	public void handle(String id){
		// TODO Auto-generated method stub
		TransferReceiptPO po = find(id);
		po.handle();
		update(id,po);
	}

}
