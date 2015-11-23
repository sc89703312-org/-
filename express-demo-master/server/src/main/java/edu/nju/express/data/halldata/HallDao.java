package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.po.*;



public interface HallDao {
	
	public void insert(HallPo hallPo);
	public void delete(String id);
	public ArrayList<HallPo> getAll();
	
	
}
