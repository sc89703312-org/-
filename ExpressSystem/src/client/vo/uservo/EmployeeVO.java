package client.vo.uservo;

import client.po.Role;

public class EmployeeVO {
	private String id;
	private String name;
	private Role role;
	
	/**
	 * @param id
	 * @param name
	 * @param role
	 */
	public EmployeeVO(String id, String name, Role role) {
		this.id = id;
		this.name = name;
		this.role = role;
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

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
}

