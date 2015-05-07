package com.equipment.pojo;

public class ResultPojo {
	private int sEcho;
	private long iTotalRecords;
	private int iTotalDisplayRecords;
	private Object[] aaData;
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(long l) {
		this.iTotalRecords = l;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Object[] getAaData() {
		return aaData;
	}
	public void setAaData(Object[] obj1) {
		this.aaData = obj1;
	}
	
}
