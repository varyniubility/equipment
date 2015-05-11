package com.equipment.service.impl.yhxt.sbfw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipment.dao.yhxt.sbfw.ISbfwDao;
import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.PointData;
import com.equipment.pojo.Province;
import com.equipment.pojo.QueryPoint;
import com.equipment.service.yhxt.sbfw.SbfwService;

@Service("SbfwService")
public class SbfwServiceImpl implements SbfwService{
	
	@Autowired
	private ISbfwDao sbfwdao;
	@Override
	public List<Province> getAllPro() {
		return sbfwdao.getAllPro();
	}

	@Override
	public List<City> getCityByProId(String proid) {
		return sbfwdao.getCityByProId(proid);
	}

	@Override
	public List<District> getDistinctByCityId(String cityid) {
		return sbfwdao.getDistinctByCityId(cityid);
	}

	@Override
	public List<PointData> queryPoint(QueryPoint queryPoint) {
		// TODO Auto-generated method stub
		return sbfwdao.queryPoint(queryPoint);
	}

}
