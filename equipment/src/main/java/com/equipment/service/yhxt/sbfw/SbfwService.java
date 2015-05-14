package com.equipment.service.yhxt.sbfw;

import java.util.List;

import com.equipment.pojo.City;
import com.equipment.pojo.District;
<<<<<<< HEAD
import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Fwsqd;
=======
import com.equipment.pojo.PointData;
>>>>>>> master
import com.equipment.pojo.Province;
import com.equipment.pojo.QueryPoint;

public interface SbfwService {
	public List<Province> getAllPro();
	public List<City> getCityByProId(String proid);
	public List<District> getDistinctByCityId(String cityid);
<<<<<<< HEAD
	public List<DmZsly> getAllZsly();
	public List<Fwsqd> getAllFwsqd(String sbxlh);
	public int addFwsqd(Fwsqd fwsqd);
	public List<Fwsqd> getSqdmx(String sqdbh);
	public int updateFwsqd(Fwsqd fwsqd);
=======
	public List<PointData> queryPoint(QueryPoint queryPoint);
>>>>>>> master
}
