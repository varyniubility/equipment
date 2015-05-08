package com.equipment.pojo;

public class City {
	private String cityid;
	private String cityname;
	private String provinceid;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", cityname=" + cityname
				+ ", provinceid=" + provinceid + "]";
	}


}
