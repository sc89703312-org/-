package edu.nju.express.data.userdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserMessagePO;

public interface UserMessageDao {

	public ResultMessage insert(UserMessagePO po);
	
	public ResultMessage delete(String id);
	
	public UserMessagePO find(String id);
	
	public ArrayList<UserMessagePO> getAll();
	
	public ArrayList<UserMessagePO> showAll();

	public void flush();
}
