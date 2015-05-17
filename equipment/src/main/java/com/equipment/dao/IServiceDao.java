package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.ServiceForm;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IServiceDao {

	List<ServiceForm> queryService(DatatableParams dtp);

}
