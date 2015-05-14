package com.equipment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IAdminInfoDao;
import com.equipment.dao.IBaseInfoDao;
import com.equipment.pojo.AdminInfo;
import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.SelectedData;
import com.equipment.service.AdminInfoService;
import com.equipment.utils.MD5;

@Component
@Service("admininfo")
public class AdminInfoServiceImpl implements AdminInfoService {

	@Autowired
	public IAdminInfoDao adminInfoDao;
	
	@Override
	public String modifyPassword(String oldpassword, String newpassword,
			String confirmpwd,String userid) {
		String password = adminInfoDao.queryPassword(userid);
		MD5 md5 = new MD5();
		String md5OldPassword = md5.GetMD5Code(oldpassword);
		String md5NewPawssword = md5.GetMD5Code(newpassword);
		String md5ConfirmPwd = md5.GetMD5Code(confirmpwd);
		String resultStr = null;
		if(password.equals(md5OldPassword)){
			if(md5NewPawssword.equals(md5ConfirmPwd)){
				resultStr="密码修改成功！";
				adminInfoDao.modifyPassword(md5NewPawssword,userid);
			}else{
				resultStr="两次输入密码不同！";
			}
		}else{
			resultStr="原始密码不正确！";
		}
		return resultStr;
	}

	@Override
	public List<SelectedData> queryProvince() {
		List<SelectedData> result = adminInfoDao.queryProvince();
		return result;
	}

	@Override
	public List<SelectedData> queryCity(String provinceid) {
		List<SelectedData> result = adminInfoDao.queryCity(provinceid);
		return result;
	}

	@Override
	public List<SelectedData> queryDistrict(String cityid) {
		List<SelectedData> result = adminInfoDao.queryDistrict(cityid);
		return result;
	}

	@Override
	public List<AdminInfo> saveModify(AdminInfo adminInfo) {
		List<AdminInfo> result = adminInfoDao.saveModify(adminInfo);
		return result;
	}

	@Override
	public AdminInfo queryInfo(String userid) {
		AdminInfo result = adminInfoDao.queryInfo(userid);
		return result;
	}

}
