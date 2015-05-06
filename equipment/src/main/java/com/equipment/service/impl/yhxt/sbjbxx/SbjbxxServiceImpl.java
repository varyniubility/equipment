package com.equipment.service.impl.yhxt.sbjbxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipment.dao.yhxt.sbjbxx.ISbjbxxDao;
import com.equipment.pojo.Sbjbxx;
import com.equipment.service.yhxt.sbjbxx.SbjbxxService;

@Service("SbjbxxService")
public class SbjbxxServiceImpl implements SbjbxxService{
	
	@Autowired
	private ISbjbxxDao sbjbxxdao;
	@Override
	public Sbjbxx getsbjbxx(String sbxlh) {
		
		return sbjbxxdao.getsbjbxx(sbxlh);
	}

}
