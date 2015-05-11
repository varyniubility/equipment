package com.equipment.pojo;

public class PointData {

	private String zdmc;
	private String zddh;
	private String province;
	private String provincename;
	private String city;
	private String cityname;
	private String district;
	private String districtname;
	private String xxdz;
	private String zdjd;
	private String zdwd;
	
	public String getZddh() {
		return zddh;
	}
	public void setZddh(String zddh) {
		this.zddh = zddh;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getZdmc() {
		return zdmc;
	}
	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getXxdz() {
		return xxdz;
	}
	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}
	public String getZdjd() {
		return zdjd;
	}
	public void setZdjd(String zdjd) {
		this.zdjd = zdjd;
	}
	public String getZdwd() {
		return zdwd;
	}
	public void setZdwd(String zdwd) {
		this.zdwd = zdwd;
	}
	@Override
	public String toString() {
		return "PointData [zdmc=" + zdmc + ", province=" + province + ", city="
				+ city + ", district=" + district + ", xxdz=" + xxdz
				+ ", zdjd=" + zdjd + ", zdwd=" + zdwd + "]";
	}
	
}
