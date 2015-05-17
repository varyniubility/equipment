package com.equipment.service.yhxt.sbcjwt;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.pojo.Sbcjwt;

@Component
@Service("SbcjwtService")
public interface SbcjwtService {
	public List<Sbcjwt> getsbcjwt(String sblx);
}
