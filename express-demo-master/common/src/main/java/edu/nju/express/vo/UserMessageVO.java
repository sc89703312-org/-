package edu.nju.express.vo;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;




public class UserMessageVO {

	private StaffChange operation;
	private String id;
	private String name;
	private Role role;
	
	/**
	 * @param operation
	 * @param id
	 * @param name
	 * @param role
	 */
	public UserMessageVO(StaffChange operation, String id, String name, Role role) {
		this.operation = operation;
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public StaffChange getOperation() {
		return operation;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserMessageVO [operation=" + operation + ", id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
