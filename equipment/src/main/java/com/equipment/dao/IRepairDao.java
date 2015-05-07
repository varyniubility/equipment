package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.ServiceForm;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IRepairDao {

	public List<ServiceForm> queryService();
}
