package com.equipment.service;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.SelectedData;
public interface RepairService {

	public ResultPojo queryService(DatatableParams dtparam);

	public List<DropDownJd> queryjd(String jddm);

	public String modifyjd(ModifyJd modifyjd);

	public List<SelectedData> queryCity(String provinceid);

	public List<SelectedData> queryProvince();

	public List<SelectedData> queryDistrict(String cityid);
}
