package com.equipment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IBaseInfoDao;
import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.SelectedData;
import com.equipment.service.BaseInfoService;
import com.equipment.utils.MD5;

@Component
@Service("baseinfo")
public class BaseInfoServiceImpl implements BaseInfoService {

	@Autowired
	public IBaseInfoDao baseInfoDao;
	
	@Override
	public String modifyPassword(String oldpassword, String newpassword,
			String confirmpwd,String userid) {
		String password = baseInfoDao.queryPassword(userid);
		MD5 md5 = new MD5();
		String md5OldPassword = md5.GetMD5Code(oldpassword);
		String md5NewPawssword = md5.GetMD5Code(newpassword);
		String md5ConfirmPwd = md5.GetMD5Code(confirmpwd);
		String resultStr = null;
		if(oldpassword == null || oldpassword.equals("")){
			resultStr="原始密码为空值！";
		}else if(newpassword == null || newpassword.equals("")){
			resultStr="请输入新密码！";
		}else{
			if(password.equals(md5OldPassword)){
				if(md5NewPawssword.equals(md5ConfirmPwd)){
					resultStr="密码修改成功！";
					baseInfoDao.modifyPassword(md5NewPawssword,userid);
				}else{
					resultStr="两次输入密码不同！";
				}
			}else{
				resultStr="原始密码不正确！";
			}
		}
		return resultStr;
	}

	@Override
	public List<SelectedData> queryProvince() {
		List<SelectedData> result = baseInfoDao.queryProvince();
		return result;
	}

	@Override
	public List<SelectedData> queryCity(String provinceid) {
		List<SelectedData> result = baseInfoDao.queryCity(provinceid);
		return result;
	}

	@Override
	public List<SelectedData> queryDistrict(String cityid) {
		List<SelectedData> result = baseInfoDao.queryDistrict(cityid);
		return result;
	}

	@Override
	public String saveModify(BaseInfo baseInfo) {
		Integer num = baseInfoDao.saveModify(baseInfo);
		if(num > 0){
			return "success";
		}else{
			return "fail";
		}
	}

	@Override
	public BaseInfo queryInfo(String userid) {
		BaseInfo result = baseInfoDao.queryInfo(userid);
		return result;
	}

}
