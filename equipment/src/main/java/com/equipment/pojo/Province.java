package com.equipment.pojo;

public class Province {
	private String provinceid;
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	private String provincename;
	@Override
	public String toString() {
		return "Province [provinceid=" + provinceid + ", provincename="
				+ provincename + "]";
	}


}
