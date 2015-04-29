package com.equipment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.ILoginDao;
import com.equipment.pojo.Login;
import com.equipment.pojo.yhxt.Sbjbxx;
import com.equipment.service.LoginService;
import com.equipment.utils.MD5;

@Component
@Service("login")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public ILoginDao loginDao;

	@Override
	public String login(String username, String password) {
		List<Login> pwdList = loginDao.login(username);
		MD5 md5 = new MD5();
		String md5Password = md5.GetMD5Code(password);
		String resultStr = "pages/login/login";
		for (Login login : pwdList) {
			if (md5Password.equals(login.getYhmm()) && login.getYhmm() != null) {
				if (login.getYhlb().equals("0") && login.getYhlb() != null) {
					resultStr = "pages/main/adminMain";
				} else if (login.getYhlb().equals("1")
						&& login.getYhlb() != null) {
					resultStr = "pages/main/engineerMain";
				} else {
					resultStr = "pages/login/login";
				}
			} else {
				resultStr = "pages/login/login";
			}
		}
		return resultStr;
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
