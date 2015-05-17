package com.equipment.pojo;

public class DatatableParams {

	int sEcho;
	int iDisplayStart;
	int iDisplayLength;
	String yhxm;
	String yhlb;
	String start;
	String end;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getYhxm() {
		return yhxm;
	}
	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}
	public String getYhlb() {
		return yhlb;
	}
	public void setYhlb(String yhlb) {
		this.yhlb = yhlb;
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
		return "DatatableParams [sEcho=" + sEcho + ", iDisplayStart="
				+ iDisplayStart + ", iDisplayLength=" + iDisplayLength
				+ ", yhxm=" + yhxm + ", yhlb=" + yhlb + "]";
	}
	
}
