package com.equipment.pojo;

public class Point {

	private String id;
	private String name;
	private String province;
	private String city;
	private String district;
	private String address;
	private String telphone;
	private String zdjd;
	private String zdwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
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
		return "Point [name=" + name + ", province=" + province + ", city="
				+ city + ", district=" + district + ", address=" + address
				+ ", telphone=" + telphone + ", adjd=" + zdjd + ", zdwd="
				+ zdwd + "]";
	}
	
}
