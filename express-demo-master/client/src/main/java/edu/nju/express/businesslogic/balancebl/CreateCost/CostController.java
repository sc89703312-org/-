package edu.nju.express.businesslogic.balancebl.CreateCost;

import java.util.ArrayList;

import edu.nju.express.blservice.CostControlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Balancevo;


/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:20:27
 * 
 * 用于付款单的新建和查看
 */


public class CostController implements CostControlService{

	private CostControlService costControlBL;
	
	public CostController() {
		// TODO Auto-generated constructor stub
	
		costControlBL = DataFactory.createCostInstance();
	
	}
	
	
	@Override
	public ResultMessage createCost(Balancevo vo) {
		// TODO Auto-generated method stub
		return costControlBL.createCost(vo);
	}

	@Override
	public void endCostControl() {
		// TODO Auto-generated method stub
		costControlBL.endCostControl();
	}

	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		return costControlBL.viewAllCost();
	}

	@Override
	public double caculatePostManSalary(String id) {
		// TODO Auto-generated method stub
		return costControlBL.caculatePostManSalary(id);
	}

	@Override
	public double caculateDriverSalary(String turns) {
		// TODO Auto-generated method stub
		return costControlBL.caculateDriverSalary(turns);
	}

	@Override
	public double caculateFare(String transferID) {
		// TODO Auto-generated method stub
		return costControlBL.caculateFare(transferID);
	}

	@Override
	public double caculateClerkSalary() {
		// TODO Auto-generated method stub
		return costControlBL.caculateClerkSalary();
	}

}
