package com.equipment.dao;

import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IBaseInfoDao {

	public String queryPassword(String userid);

	public void modifyPassword(String md5NewPawssword, String userid);
}
