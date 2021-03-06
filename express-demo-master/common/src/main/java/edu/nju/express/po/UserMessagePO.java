package edu.nju.express.po;

import java.io.Serializable;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;

/**
 * 人员变动申请的持久化对象
 * @author Dora
 * @version 2015-12-9 22:29:00
 */

public class UserMessagePO extends PersistentObj implements Serializable{

	private static final long serialVersionUID = -7595964527752101953L;
	private StaffChange operation;

	private String name;
	private Role role;
	
	/**
	 * @param operation 对人员的操作
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
		this.date = "";
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
