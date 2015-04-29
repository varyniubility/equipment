package com.equipment.service.impl.yhxt.sbcjwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipment.dao.yhxt.sbcjwt.ISbcjwtDao;
import com.equipment.pojo.yhxt.Sbcjwt;
import com.equipment.service.yhxt.sbcjwt.SbcjwtService;

@Service("SbcjwtService")
public class SbcjwtServiceImpl implements SbcjwtService{

	@Autowired
	private ISbcjwtDao sbcjwtdao;
	@Override
	public List<Sbcjwt> getsbcjwt(String sblx) {
		
		return sbcjwtdao.getSbcjwt(sblx);
	}

}
