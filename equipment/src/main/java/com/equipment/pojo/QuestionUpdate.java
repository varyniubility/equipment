package com.equipment.pojo;

public class QuestionUpdate {

	private String wtdm;
	private String jddm;
	private String wtjd;
	private String gcszj;
	public String getWtdm() {
		return wtdm;
	}
	public void setWtdm(String wtdm) {
		this.wtdm = wtdm;
	}
	public String getJddm() {
		return jddm;
	}
	public void setJddm(String jddm) {
		this.jddm = jddm;
	}
	public String getWtjd() {
		return wtjd;
	}
	public void setWtjd(String wtjd) {
		this.wtjd = wtjd;
	}
	public String getGcszj() {
		return gcszj;
	}
	public void setGcszj(String gcszj) {
		this.gcszj = gcszj;
	}
	@Override
	public String toString() {
		return "QuestionUpdate [wtdm=" + wtdm + ", jddm=" + jddm + ", wtjd="
				+ wtjd + ", gcszj=" + gcszj + "]";
	}
	
}
