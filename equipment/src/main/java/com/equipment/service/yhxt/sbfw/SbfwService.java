package com.equipment.service.yhxt.sbfw;

import java.util.List;

import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.PointData;
import com.equipment.pojo.Province;
import com.equipment.pojo.QueryPoint;

public interface SbfwService {
	public List<Province> getAllPro();
	public List<City> getCityByProId(String proid);
	public List<District> getDistinctByCityId(String cityid);
	public List<PointData> queryPoint(QueryPoint queryPoint);
}
