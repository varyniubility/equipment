package com.equipment.service;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.DropDownJd;
public interface RepairService {

	public ResultPojo queryService(DatatableParams dtparam);

	public List<DropDownJd> queryjd(String jddm);

	public String modifyjd(ModifyJd modifyjd);
}
