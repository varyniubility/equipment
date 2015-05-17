package com.equipment.dao.yhxt.sbcjwt;

import java.util.List;

import org.springframework.stereotype.Component;

import com.equipment.pojo.Sbcjwt;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface ISbcjwtDao {
	public List<Sbcjwt> getSbcjwt(String sblx);
}
