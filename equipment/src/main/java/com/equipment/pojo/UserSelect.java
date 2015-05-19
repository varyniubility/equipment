package com.equipment.pojo;

public class UserSelect {

	private String yhdm;
	private String yhxm;
	public String getYhdm() {
		return yhdm;
	}
	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}
	public String getYhxm() {
		return yhxm;
	}
	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}
	@Override
	public String toString() {
		return "UserSelect [yhdm=" + yhdm + ", yhxm=" + yhxm + "]";
	}
	
}
