package com.equipment.pojo;

public class QueryParams {
	String hospital;
	String clinic;
	String village;
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	@Override
	public String toString() {
		return "QueryParams [hospital=" + hospital + ", clinic=" + clinic
				+ ", village=" + village + "]";
	}
	
}
