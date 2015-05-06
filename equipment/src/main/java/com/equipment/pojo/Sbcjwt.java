package com.equipment.pojo;

public class Sbcjwt {
	private String sblx;
	private String cjwt;
	private String cjwtjd;
	private String lsh;
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	@Override
	public String toString() {
		return "Sbcjwt [sblx=" + sblx + ", cjwt=" + cjwt + ", cjwtjd=" + cjwtjd
				+ ", lsh=" + lsh + "]";
	}
	public String getSblx() {
		return sblx;
	}
	public void setSblx(String sblx) {
		this.sblx = sblx;
	}
	public String getCjwt() {
		return cjwt;
	}
	public void setCjwt(String cjwt) {
		this.cjwt = cjwt;
	}
	public String getCjwtjd() {
		return cjwtjd;
	}
	public void setCjwtjd(String cjwtjd) {
		this.cjwtjd = cjwtjd;
	}

}
