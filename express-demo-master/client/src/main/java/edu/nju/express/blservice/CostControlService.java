package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Balancevo;



public interface CostControlService {
	public ResultMessage createCost(Balancevo vo);
	public void endCostControl();
	public ArrayList<Balancevo> viewAllCost();
}
