package edu.nju.express.vo;

import edu.nju.express.common.Role;



public class UserVO {
	private String id;
	private String name;
	private Role role;
	private String password;
	
	/**
	 * @param id
	 * @param name
	 * @param role
	 * @param password
	 */
	public UserVO(String id, String name, Role role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
	}

	public void show(){
		System.out.println(id+" "+name+" "+role+" ");
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
	public String getPassword(){
		return password;
	}
	
	
}
