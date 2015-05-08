package com.equipment.service;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.ServiceForm;

public interface RepairService {

	public ResultPojo queryService(DatatableParams dtparam);
}
