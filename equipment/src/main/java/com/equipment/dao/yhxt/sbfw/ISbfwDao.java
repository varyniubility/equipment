package com.equipment.dao.yhxt.sbfw;

import java.util.List;

import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.Province;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ISbfwDao {
	public List<Province> getAllPro();
	public List<City> getCityByProId(String proid);
	public List<District> getDistinctByCityId(String cityid);
	public List<DmZsly> getAllZsly();
	public List<Fwsqd> getAllFwsqd(String sbxlh);
	public int addFwsqd(Fwsqd fwsqd);
	public List<Fwsqd> getSqdmx(String sqdbh);
	public int updateFwsqd(Fwsqd fwsqd);
	
}
