package com.equipment.dao.yhxt.sbjbxx;


import org.springframework.stereotype.Component;

import com.equipment.pojo.yhxt.Sbjbxx;
import com.equipment.utils.MyBatisRepository;

@Component
@MyBatisRepository
public interface ISbjbxxDao {
	public Sbjbxx getsbjbxx(String sbxlh);
}
