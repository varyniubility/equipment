package com.equipment.dao.yhxt.sbwtfk;

import java.util.List;

import org.springframework.stereotype.Component;

import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Sbwtfk;
import com.equipment.utils.MyBatisRepository;

@Component
@MyBatisRepository
public interface ISbwtfkDao {
	public List<DmZsly> getzsly();
	public int insertzsly(Sbwtfk sbwtfk);
	public List<Sbwtfk> getsbwtfk(String sbxlh);
	public int updatewtpj(Sbwtfk sbwtfk);
}
