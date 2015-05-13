package com.equipment.service;

import java.util.List;

import com.equipment.pojo.AdminInfo;
import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.SelectedData;

public interface AdminInfoService {

	public String modifyPassword(String oldpassword,String newpassword,String confirmpwd,String userid);

	public List<SelectedData> queryProvince();
	
	public List<SelectedData> queryCity(String provinceid);

	public List<SelectedData> queryDistrict(String cityid);

	public List<AdminInfo> saveModify(AdminInfo baseInfo);

	public AdminInfo queryInfo(String userid);
}
