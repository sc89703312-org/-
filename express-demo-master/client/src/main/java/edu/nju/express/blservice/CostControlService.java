package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.Etype;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Balancevo;



public interface CostControlService {
	public ResultMessage createCost(Balancevo vo);
	public void endCostControl();
	public ArrayList<Balancevo> viewAllCost();
	public double caculatePostManSalary(String id);
	public double caculateDriverSalary(String turns);
	public double caculateFare(String transferID);
	public double caculateClerkSalary();
}
