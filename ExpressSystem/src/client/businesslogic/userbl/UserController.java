package client.businesslogic.userbl;

import client.ResultMessage;
import client.blservice.userblservice.UserBlService;
import client.po.Role;

public class UserController implements UserBlService{

	UserBlService user;
	
	/**
	 * @param user
	 */
	public UserController(UserBlService user) {
		this.user = user;
	}

	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		return user.addUser(id, name, role, password);
	}

	@Override
	public ResultMessage deleteUser(String id) {
		return user.deleteUser(id);
	}

	@Override
	public ResultMessage modifyUser(String id, String name, Role role, String password) {
		return user.modifyUser(id, name, role, password);
	}

}
