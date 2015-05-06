package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.Login;
import com.equipment.pojo.Sbjbxx;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ILoginDao {

	public List<Login> login(String username);
	public List<Sbjbxx> customlogin(String number);
}
