package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
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
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list) {
		// TODO Auto-generated method stub
		for(ArrivalReceiptPO arrivalpo:list){
			arrivalpo.approve();
		}
	}

	/**
	 * 
	 */
	

}
