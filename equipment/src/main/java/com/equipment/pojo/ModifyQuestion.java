package com.equipment.pojo;

public class ModifyQuestion {

	private String wtdm;
	private String glydm;
	private String gcsdm;
	public String getWtdm() {
		return wtdm;
	}
	public void setWtdm(String wtdm) {
		this.wtdm = wtdm;
	}
	public String getGlydm() {
		return glydm;
	}
	public void setGlydm(String glydm) {
		this.glydm = glydm;
	}
	public String getGcsdm() {
		return gcsdm;
	}
	public void setGcsdm(String gcsdm) {
		this.gcsdm = gcsdm;
	}
	@Override
	public String toString() {
		return "ModifyQuestion [wtdm=" + wtdm + ", glydm=" + glydm + ", gcsdm="
				+ gcsdm + "]";
	}
	
}
