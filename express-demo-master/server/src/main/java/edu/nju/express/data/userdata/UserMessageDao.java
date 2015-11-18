package edu.nju.express.data.userdata;

import java.util.ArrayList;

import edu.nju.express.po.UserMessagePO;

public interface UserMessageDao {

	public int insert(UserMessagePO po);
	
	public int delete(String id);
	
	public UserMessagePO find(String id);
	
	public ArrayList<UserMessagePO> getAll();

	public void flush();
}
