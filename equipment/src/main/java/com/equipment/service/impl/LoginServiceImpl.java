package com.equipment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.ILoginDao;
import com.equipment.service.LoginService;

@Component
@Service("login")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public ILoginDao loginDao;
	
	@Override
	public String login(String username){
//		List<String> pwdList = loginDao.login(username);
		return "/equipment/pages/main/main";
	}
}
