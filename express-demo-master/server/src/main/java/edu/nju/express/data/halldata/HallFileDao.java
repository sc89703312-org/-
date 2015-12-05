package edu.nju.express.data.halldata;


import edu.nju.express.common.CommonData;
import edu.nju.express.po.HallPo;

public class HallFileDao extends CommonData<HallPo> implements HallDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLocation(String id) {
		// TODO Auto-generated method stub
		return find(id).getName();
	}
	
}
