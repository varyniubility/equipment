package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.UserInfo;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IUserDao {

	public List<UserInfo> queryUser(DatatableParams dtparam);
	
	public List<SelectedData> queryProvince();
	
	public List<SelectedData> queryCity(String provinceid);
	
	public List<SelectedData> queryDistrict(String cityid);

	public Integer addUserInfo(UserInfo userInfo);
	
	public Integer addUser(UserInfo userInfo);
	
	public Integer deleteUserInfo(String userid);
	
	public Integer deleteUser(String userid);
	
	public String queryMaxId();

	public Integer modifyUserInfo(UserInfo userInfo);

	public Integer modifyUser(UserInfo userInfo);
}
