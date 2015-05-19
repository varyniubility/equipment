package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.ApplyOrder;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.ServiceForm;
import com.equipment.pojo.UserSelect;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IServiceDao {

	List<ServiceForm> queryService(DatatableParams dtp);

	List<SelectedData> queryProvince();

	List<SelectedData> queryCity(String provinceid);

	List<SelectedData> queryDistrict(String cityid);

	List<SelectedData> queryEngineer();

	List<SelectedData> queryAdmin();

	void saveOrder(ApplyOrder applyOrder);

	String queryMaxId();

	List<SelectedData> queryJd();
}
