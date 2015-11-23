package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.po.DeliverReceiptPO;

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
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list) {
		// TODO Auto-generated method stub
		for(DeliverReceiptPO deliverpo:list){
			deliverpo.approve();
		}
	}

	

}
