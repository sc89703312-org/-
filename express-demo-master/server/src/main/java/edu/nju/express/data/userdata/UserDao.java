package edu.nju.express.data.userdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserPO;

public interface UserDao {
	
	public int insert(UserPO po);
	
	public int delete(String id);
	
	public int modify(UserPO po);
	
	public UserPO find(String id);
	
	public ArrayList<UserPO> getAll();

	public void flush();
	
}
