package org.think.web.bean;

import java.util.List;

public class Role {

	private String roleId;
	
	private String roleName;
	
	private List<String> author;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + "]";
	}
	
}
