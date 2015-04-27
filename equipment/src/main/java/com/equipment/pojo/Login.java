package com.equipment.pojo;

public class Login {

	private String yhmm;
	private String yhlb;
	public String getYhmm() {
		return yhmm;
	}
	public void setYhmm(String yhmm) {
		this.yhmm = yhmm;
	}
	public String getYhlb() {
		return yhlb;
	}
	public void setYhlb(String yhlb) {
		this.yhlb = yhlb;
	}
	@Override
	public String toString() {
		return "Login [yhmm=" + yhmm + ", yhlb=" + yhlb + "]";
	}
	
}
