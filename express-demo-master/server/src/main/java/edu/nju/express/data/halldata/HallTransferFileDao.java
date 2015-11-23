package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
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
	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list) {
		// TODO Auto-generated method stub
		for(HallTransferReceiptPO transferpo : list){
			transferpo.approve();
		}
	}

	
}
