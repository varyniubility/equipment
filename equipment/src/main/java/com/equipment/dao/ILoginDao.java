package com.equipment.dao;

import java.util.List;

import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ILoginDao {

	public List<String> login(String username);
}
