package com.dxc.pojo;

public class Admin {

	private int adminid;
	private String name;
	private int password;

	public Admin() {

	}

	public Admin(int adminid, String name, int password) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", password=" + password + "]";
	}

}
