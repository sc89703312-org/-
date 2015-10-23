package client.blservice.userblservice;

import client.ResultMessage;
import client.po.Role;

public interface UserBlService {

	public ResultMessage addUser(String id, 
			String name, Role role, String password);
	
	public ResultMessage deleteUser(String id);
	
	public ResultMessage modifyUser(String id, 
			String name, Role role, String password);
	
}
