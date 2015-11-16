package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.UserMessageVO;



public interface UserBlService {

	public ResultMessage addUser(String id, 
			String name, Role role, String password);
	
	public ResultMessage deleteUser(String id);
	
	public ResultMessage modifyUser(String id, 
			String name, Role role, String password);

	public ArrayList<UserMessageVO> viewTask();
}
