package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.TransferReceiptPO;

public class ArriveFileDao extends CommonData<ArriveReceiptPO> implements ArriveReceiptDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArriveFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(ArriveReceiptPO po) {
		// TODO Auto-generated method stub
		return insert(po);
	}

	@Override
	public String getNextID(String stationID,String location) {
		// TODO Auto-generated method stub
		ArrayList<ArriveReceiptPO> list = getAllReceipt(location);
		if(list.size()!=0){
			ArriveReceiptPO po = list.get(list.size()-1);
			return Integer.parseInt(po.getId().substring(15, po.getId().length()))+1+"";
		}
		else
			return stationID+"000000";
	}

	@Override
	public ArrayList<ArriveReceiptPO> getAllReceipt(String location) {
		// TODO Auto-generated method stub
		ArrayList<ArriveReceiptPO> list = getAllReceipt();
		ArrayList<ArriveReceiptPO> newlist = new ArrayList<ArriveReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getLocation().equals(location))
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	@Override
	public ArrayList<ArriveReceiptPO> getSummitArrive() {
		// TODO Auto-generated method stub
		ArrayList<ArriveReceiptPO> list = showAll();
		ArrayList<ArriveReceiptPO> newlist = new ArrayList<ArriveReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.SUBMITTED)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getApproveArrive(String stationID) {
		// TODO Auto-generated method stub
		ArrayList<ArriveReceiptPO> list = showAll();
		ArrayList<ArriveReceiptPO> newlist = new ArrayList<ArriveReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.APPROVED&&list.get(i).isHandle()==false)
				newlist.add(list.get(i));
		return newlist;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		ArriveReceiptPO po = find("ArriveReceipt"+id);
		po.approve();
		update("ArriveReceipt"+id,po);
		return null;
	}

	@Override
	public void handle(String id) {
		// TODO Auto-generated method stub
		ArriveReceiptPO po = find(id);
		po.handle();
		update(id,po);
	}

}
