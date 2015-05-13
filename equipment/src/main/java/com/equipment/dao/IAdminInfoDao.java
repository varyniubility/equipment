package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.AdminInfo;
import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.SelectedData;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IAdminInfoDao {

	public String queryPassword(String userid);

	public void modifyPassword(String md5NewPawssword, String userid);

	public List<SelectedData> queryProvince();
	
	public List<SelectedData> queryCity(String provinceid);
	
	public List<SelectedData> queryDistrict(String cityid);
	
	public List<AdminInfo> saveModify(AdminInfo adminInfo);
	
	public AdminInfo queryInfo(String userid);
}
