package com.equipment.dao.yhxt.sbfw;

import java.util.List;

import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.Province;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ISbfwDao {
	public List<Province> getAllPro();
	public List<City> getCityByProId(String proid);
	public List<District> getDistinctByCityId(String cityid);
	
}
