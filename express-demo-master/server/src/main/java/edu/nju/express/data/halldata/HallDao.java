package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.*;



public interface HallDao {
	
	public ResultMessage insert(HallPo hallPo);
	public ResultMessage delete(String id);
	public String getLocation(String id);
	public ArrayList<HallPo> showAll();
	public void flush();
}
