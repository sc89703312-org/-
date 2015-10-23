package client.blservice.userblservice.test;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.po.Role;

public class UserBlService_Stub implements UserBlService{

	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		if(id.equals("025000001"))
			return ResultMessage.INVALID;
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage deleteUser(String id) {
		// TODO Auto-generated method stub
		if(id.equals("025000001"))
			return ResultMessage.VALID;
		return ResultMessage.INVALID;
	}

	@Override
	public ResultMessage modifyUser(String id, String name, Role role, String password) {
		// TODO Auto-generated method stub
		if(id.equals("025000001"))
			return ResultMessage.VALID;
		return ResultMessage.INVALID;
	}

}
