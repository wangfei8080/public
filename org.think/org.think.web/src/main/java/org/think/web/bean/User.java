package org.think.web.bean;

import java.util.Date;

public class User {
	
	private String uid;
	
	private String name;
	
	private Date birthday;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private int recode;
	
	private String roleId;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRecode() {
		return recode;
	}

	public void setRecode(int recode) {
		this.recode = recode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}
