package com.equipment.service.impl.yhxt.sbwtfk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipment.dao.yhxt.sbwtfk.ISbwtfkDao;
import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Sbwtfk;
import com.equipment.service.yhxt.sbwtfk.SbwtfkService;

@Service("SbwtfkService")
public class SbwtfkServiceImpl implements SbwtfkService{
	
	@Autowired
	private ISbwtfkDao sbwtfkdao;
	@Override
	public List<DmZsly> getzsly() {
		return sbwtfkdao.getzsly();
	}

	@Override
	public int insertzsly(Sbwtfk sbwtfk) {
		return sbwtfkdao.insertzsly(sbwtfk);
	}

	@Override
	public List<Sbwtfk> getsbwtfk(String sbxlh) {
		return sbwtfkdao.getsbwtfk(sbxlh);
	}

	@Override
	public int updatewtpj(Sbwtfk sbwtfk) {
		return sbwtfkdao.updatewtpj(sbwtfk);
	}

}
