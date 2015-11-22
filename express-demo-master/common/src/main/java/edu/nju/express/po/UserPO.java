package edu.nju.express.po;

import java.io.Serializable;

import edu.nju.express.common.Role;



public class UserPO  extends PersistentObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3613670690872702254L;

	private String name;
	private Role role;
	private String password;
	
	/**
	 * @param id
	 * @param name
	 * @param role
	 * @param password
	 */
	public UserPO(String id, String name, Role role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.date = "";
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

	public String getPassword() {
		return password;
	}
	
}
