package com.equipment.service.impl.yhxt.sbfw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipment.dao.yhxt.sbfw.ISbfwDao;
import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.Province;
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
	public List<DmZsly> getAllZsly() {
		// TODO Auto-generated method stub
		return sbfwdao.getAllZsly();
	}

	@Override
	public List<Fwsqd> getAllFwsqd(String sbxlh) {
		// TODO Auto-generated method stub
		return sbfwdao.getAllFwsqd(sbxlh);
	}

	@Override
	public int addFwsqd(Fwsqd fwsqd) {
		// TODO Auto-generated method stub
		return sbfwdao.addFwsqd(fwsqd);
	}

	@Override
	public List<Fwsqd> getSqdmx(String sqdbh) {
		// TODO Auto-generated method stub
		return sbfwdao.getSqdmx(sqdbh);
	}

	@Override
	public int updateFwsqd(Fwsqd fwsqd) {
		// TODO Auto-generated method stub
		return sbfwdao.updateFwsqd(fwsqd);
	}


}
