package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.*;


public interface HallBLService {

	public ResultMessage addHall(String id, String location);;

	public ResultMessage removeHall(String id);

	public ArrayList<HallVO> showHall();

	
	
}
