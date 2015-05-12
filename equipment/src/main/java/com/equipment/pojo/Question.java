package com.equipment.pojo;

public class Question {

	String userid;
	int sEcho;
	int iDisplayStart;
	int iDisplayLength;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	@Override
	public String toString() {
		return "Question [userid=" + userid + ", sEcho=" + sEcho
				+ ", iDisplayStart=" + iDisplayStart + ", iDisplayLength="
				+ iDisplayLength + "]";
	}
	
}
