package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

public interface CostApproveInfo {

    public ArrayList<Balancevo> viewAllCostSubmitted();
	
	public void approveCost(String id);
}
