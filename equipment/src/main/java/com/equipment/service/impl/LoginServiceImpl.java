package com.equipment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.ILoginDao;
import com.equipment.pojo.Login;
import com.equipment.pojo.Sbjbxx;
import com.equipment.service.LoginService;
import com.equipment.utils.MD5;

@Component
@Service("login")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public ILoginDao loginDao;

	@Override
	public Map<String,String> login(String username, String password) {
		List<Login> pwdList = loginDao.login(username);
		Map<String,String> userMap = new HashMap<>();
		MD5 md5 = new MD5();
		String md5Password = md5.GetMD5Code(password);
		String resultStr = "pages/login/login";
		for (Login login : pwdList) {
			if (md5Password.equals(login.getYhmm()) && login.getYhmm() != null) {
				if (login.getYhlb().equals("0") && login.getYhlb() != null) {
					userMap.put("userid", login.getYhdm());
					userMap.put("view", "pages/main/adminMain");
				} else if (login.getYhlb().equals("1")
						&& login.getYhlb() != null) {
					userMap.put("userid", login.getYhdm());
					userMap.put("view", "pages/main/engineerMain");
				} else {
					userMap.put("userid", "");
					userMap.put("view", "pages/login/login");
				}
			} else {
				userMap.put("userid", "");
				userMap.put("view", "pages/login/login");
			}
		}
		return userMap;
	}

	@Override
	public Sbjbxx customlogin(String number) {
		List<Sbjbxx> sbjbxxlist = loginDao.customlogin(number);
		if (sbjbxxlist != null) {
			for (Sbjbxx login : sbjbxxlist) {
				if (login.getSbxlh().equals(number)) {
					return login;
				}
			}
		}
		return null;
	}
}
