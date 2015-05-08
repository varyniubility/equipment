package com.equipment.pojo;

public class District {
	private String districtid;
	private String districtname;
	private String cityid;
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	@Override
	public String toString() {
		return "Distinct [districtid=" + districtid + ", districtname="
				+ districtname + ", cityid=" + cityid + "]";
	}

}
