package edu.nju.express.businesslogic.strategybl.constantsettingbl;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ConstantVO;


/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:40:59
 * 
 * 总经理进行常量制定时界面与业务逻辑层的交互
 */
public class ConstantSettingController implements ConstantSettingBlService{

	
	private ConstantSettingBlService constantSettingBL;
	private static ConstantSettingController instance;
	
	private ConstantSettingController() {
		// TODO Auto-generated constructor stub
	
	
		constantSettingBL = DataFactory.createConstantSettingBLInstance();
	
	
	}
	
	
	
	public static ConstantSettingController getInstance()
	{
		return instance = (instance==null)?new ConstantSettingController():instance;
	}
	
	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		return constantSettingBL.setDistance(id1, id2, distance);
	}

	@Override
	public ResultMessage setPrice(double p) {
		// TODO Auto-generated method stub
		return constantSettingBL.setPrice(p);
	}

	@Override
	public ResultMessage setVehicleCost(double van, double railway,
			double airplane) {
		// TODO Auto-generated method stub
		return constantSettingBL.setVehicleCost(van, railway, airplane);
	}

	@Override
	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
		// TODO Auto-generated method stub
		return constantSettingBL.setVehicleLoad(van, railway, airplane);
	}

	@Override
	public ConstantVO getConstant() {
		// TODO Auto-generated method stub
		return constantSettingBL.getConstant();
	}

}
