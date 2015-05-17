package com.equipment.service.yhxt.sbwtfk;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Sbwtfk;

@Component
@Service("SbwtfkService")
public interface SbwtfkService {
	public List<DmZsly> getzsly();
	public int insertzsly(Sbwtfk sbwtfk);
	public List<Sbwtfk> getsbwtfk(String sbxlh);
	public int updatewtpj(Sbwtfk sbwtfk);
}
