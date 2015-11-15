package client.blservice.userblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.po.Role;
import client.vo.UserMessageVO;

public interface UserBlService {

	public ResultMessage addUser(String id, 
			String name, Role role, String password);
	
	public ResultMessage deleteUser(String id);
	
	public ResultMessage modifyUser(String id, 
			String name, Role role, String password);

	public ArrayList<UserMessageVO> viewTask();
}
