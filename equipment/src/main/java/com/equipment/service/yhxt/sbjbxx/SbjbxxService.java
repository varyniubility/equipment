package com.equipment.service.yhxt.sbjbxx;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.pojo.Sbjbxx;

@Component
@Service("SbjbxxService")
public interface SbjbxxService {
	public Sbjbxx getsbjbxx(String sbxlh);
}
