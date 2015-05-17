package com.equipment.dao.yhxt.sbjbxx;


import org.springframework.stereotype.Component;

import com.equipment.pojo.Sbjbxx;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ISbjbxxDao {
	public Sbjbxx getsbjbxx(String sbxlh);
}
