package com.equipment.service;

import java.util.List;

import com.equipment.pojo.ApplyOrder;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.UserSelect;

public interface ServiceService {

	ResultPojo queryService(DatatableParams dtp);

	List<SelectedData> queryDistrict(String cityid);

	List<SelectedData> queryCity(String provinceid);

	List<SelectedData> queryProvince();

	List<SelectedData> queryEngineer();

	List<SelectedData> queryAdmin();

	String saveOrder(ApplyOrder applyOrder);
	
	String queryMaxId();

	List<SelectedData> queryJd();

}
