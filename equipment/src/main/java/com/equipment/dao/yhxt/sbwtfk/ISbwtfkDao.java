package com.equipment.dao.yhxt.sbwtfk;

import java.util.List;

import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Sbwtfk;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ISbwtfkDao {
	public List<DmZsly> getzsly();
	public int insertzsly(Sbwtfk sbwtfk);
	public List<Sbwtfk> getsbwtfk(String sbxlh);
	public int updatewtpj(Sbwtfk sbwtfk);
}
