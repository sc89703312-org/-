package edu.nju.express.data.userdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserPO;

public interface UserDao {
	
	public ResultMessage insert(UserPO po);
	
	public ResultMessage delete(String id);
	
	public ResultMessage modify(UserPO po);
	
	public UserPO find(String id);
	
	public ArrayList<UserPO> getAll();
	 
	public ArrayList<UserPO> showAll();

	public void flush();
	
}
