package com.equipment.service;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.UserInfo;

public interface UserService {

	public ResultPojo queryUser(DatatableParams dtparam);
	
	public List<SelectedData> queryProvince();
	
	public List<SelectedData> queryCity(String provinceid);

	public List<SelectedData> queryDistrict(String cityid);

	public String addUser(UserInfo userInfo);
	
	public String queryMaxId();

	public String deleteUser(String userid);

	public String modifyUser(UserInfo userInfo);

}
