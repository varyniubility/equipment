package com.equipment.pojo;

public class ModifyPassword {

	private String userid;
	private String oldpassword;
	private String newpassword;
	private String confirmpwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	@Override
	public String toString() {
		return "ModifyPassword [userid=" + userid + ", oldpassword="
				+ oldpassword + ", newpassword=" + newpassword
				+ ", confirmpwd=" + confirmpwd + "]";
	}
	
}
