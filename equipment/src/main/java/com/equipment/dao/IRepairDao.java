package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.Point;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.ServiceForm;
import com.equipment.pojo.DropDownJd;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IRepairDao {

	public List<ServiceForm> queryService();

	public List<DropDownJd> queryjd(String jddm);

	public Integer modifyjd(ModifyJd modifyjd);

	public List<SelectedData> queryProvince();

	public List<SelectedData> queryCity(String provinceid);

	public List<SelectedData> queryDistrict(String cityid);

	public Integer queryMaxId();

	public Integer savePoint(Point point);
}
