package com.equipment.pojo;

public class Login {

	private String yhdm;
	private String yhmm;
	private String yhlb;
	private String yhm;
	
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
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
	
	public String getYhdm() {
		return yhdm;
	}
	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}
	@Override
	public String toString() {
		return "Login [yhmm=" + yhmm + ", yhlb=" + yhlb + "]";
	}
	
}
