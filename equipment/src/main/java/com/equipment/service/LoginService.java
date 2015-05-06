package com.equipment.service;

import java.util.Map;

import com.equipment.pojo.yhxt.Sbjbxx;

public interface LoginService {

	public Map<String,String> login(String username,String password);
	public Sbjbxx customlogin(String number);
}
