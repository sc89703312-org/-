package client.po.userpo;

import client.po.Role;
import client.po.StaffChange;

public class UserMessagePO {

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
	public UserMessagePO(StaffChange operation, String id, String name, Role role) {
		super();
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

	public void setOperation(StaffChange operation) {
		this.operation = operation;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
}
