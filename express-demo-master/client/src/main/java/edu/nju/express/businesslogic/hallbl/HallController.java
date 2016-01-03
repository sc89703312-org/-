package edu.nju.express.businesslogic.hallbl;

import java.util.ArrayList;

import edu.nju.express.blservice.HallBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;

public class HallController implements HallBLService{

	private HallBLService hallBL;
	private static HallController instance;
	
	private HallController() {
		// TODO Auto-generated constructor stub
	
	
		hallBL = DataFactory.createHallBLInstance();
	
	}
	
	public static HallController getInstance()
	{
		return instance = (instance == null)?new HallController():instance;
	}
	
	@Override
	public ResultMessage addHall(String id, String location) {
		// TODO Auto-generated method stub
		return hallBL.addHall(id, location);
	}

	@Override
	public ResultMessage removeHall(String id) {
		// TODO Auto-generated method stub
		return hallBL.removeHall(id);
	}

	@Override
	public ArrayList<HallVO> showHall() {
		// TODO Auto-generated method stub
		return hallBL.showHall();
	}

}
