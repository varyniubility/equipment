package com.equipment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IBaseInfoDao;
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
		if(password.equals(md5OldPassword)){
			if(md5NewPawssword.equals(md5ConfirmPwd)){
				System.out.println("密码修改成功！");
				resultStr="密码修改成功！";
				baseInfoDao.modifyPassword(md5NewPawssword,userid);
			}else{
				System.out.println("两次输入密码不同！");
				resultStr="两次输入密码不同！";
			}
		}else{
			System.out.println("原始密码不正确！");
			resultStr="原始密码不正确！";
		}
		return resultStr;
	}

}
