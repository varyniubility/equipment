package com.equipment.service;

import com.equipment.pojo.Sbjbxx;

public interface LoginService {

	public String login(String username,String password);
	public Sbjbxx customlogin(String number);
}
