package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.StationPO;

public class StationFileDao extends CommonData<StationPO> implements StationDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StationFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLocation(String id) {
		// TODO Auto-generated method stub
		StationPO po = find(id);
		return po.getName();
	}

	@Override
	public ResultMessage add(StationPO po) {
		// TODO Auto-generated method stub
		return insert(po);
	}

	@Override
	public ResultMessage remove(String id) {
		// TODO Auto-generated method stub
		return delete(id);
	}

	@Override
	public ArrayList<StationPO> showAllStation() {
		// TODO Auto-generated method stub
		return showAll();
	}
	
	public void rename(String id, String newname){
		StationPO po = find(id);
		po.rename(newname);
		update(id,po);
	}

}
