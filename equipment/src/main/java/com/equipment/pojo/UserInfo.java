package com.equipment.pojo;

public class UserInfo {

	private String yhdm;
	private String yhxm;
	private String yhxb;
	private String yhdh;
	private String yhdz;
	private String yhm;
	private String yhlb;
	private String provinceid;
	private String cityid;
	private String districtid;
	private String xxdz;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getXxdz() {
		return xxdz;
	}
	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
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
	public String getYhxb() {
		return yhxb;
	}
	public void setYhxb(String yhxb) {
		this.yhxb = yhxb;
	}
	public String getYhdh() {
		return yhdh;
	}
	public void setYhdh(String yhdh) {
		this.yhdh = yhdh;
	}
	public String getYhdz() {
		return yhdz;
	}
	public void setYhdz(String yhdz) {
		this.yhdz = yhdz;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getYhlb() {
		return yhlb;
	}
	public void setYhlb(String yhlb) {
		this.yhlb = yhlb;
	}
	@Override
	public String toString() {
		return "UserInfo [yhdm=" + yhdm + ", yhxm=" + yhxm + ", yhxb=" + yhxb
				+ ", yhdh=" + yhdh + ", yhdz=" + yhdz + ", yhm=" + yhm
				+ ", yhlb=" + yhlb + ", provinceid=" + provinceid + ", cityid="
				+ cityid + ", districtid=" + districtid + ", xxdz=" + xxdz
				+ "]";
	}
	
}
