package com.equipment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.pojo.DropDownJd;
import com.equipment.dao.IRepairDao;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.Point;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.ServiceForm;
import com.equipment.service.RepairService;

@Component
@Service("repair")
public class RepairServiceImpl implements RepairService {

	@Autowired
	public IRepairDao repairDao;
	
	@Override
	public ResultPojo queryService(DatatableParams dtparam) {
		// TODO Auto-generated method stub
		int count = 0;
		int sEcho = dtparam.getsEcho();
		int iDisplayStart = dtparam.getiDisplayStart();
		int iDisplayLength = dtparam.getiDisplayLength();
		List<ServiceForm> resultList = repairDao.queryService();
		List<ServiceForm> subList = getSubList(resultList,iDisplayStart,iDisplayLength);
		String obj1[][] = new String[subList.size()][8];
	    for(ServiceForm w:subList){
	    	obj1[count][0] = w.getSbmc();
	    	obj1[count][1] = w.getSbxh();
	    	obj1[count][2] = w.getSbys();
	    	obj1[count][3] = w.getSblx();
	    	obj1[count][4] = w.getFwlx();
	    	obj1[count][5] = w.getJdmc();
	    	obj1[count][6] = w.getJddm();
	    	obj1[count][7] = w.getSqdbh();
			count++;
	    }
		ResultPojo res = new ResultPojo();
		res.setAaData(obj1);
		res.setiTotalDisplayRecords(resultList.size());
		res.setiTotalRecords(resultList.size());
		res.setsEcho(sEcho);
		return res;
	}

	
	/**
	 * 用于分页获取当前页面需要展示的列表
	 * @param list 原始的全量数据列表
	 * @param iDisplayStart 当前页面开始的数据
	 * @param iDisplayLength 页面展示数据长度
	 * @return List<String>
	 */
	private List<ServiceForm> getSubList(List<ServiceForm> list,int iDisplayStart,int iDisplayLength){
		long total = 0;
		int pageCount = 0;
		int remainder = 0;
		int startNum = 0;
		int endNum = 0;
		int curPage = 0;
		total = list.size();
		pageCount = (int) (total/iDisplayLength);  
        remainder = (int) (total%iDisplayLength);
        if(remainder != 0){  
            pageCount = pageCount + 1;  
        }
        curPage = iDisplayStart/iDisplayLength+1;   
        startNum = iDisplayStart;  
        endNum = iDisplayStart + iDisplayLength;  
        startNum = iDisplayLength*(curPage-1); 
        if(remainder != 0){  
            if(curPage == pageCount){  
                endNum = startNum + remainder;  
            }else{  
                endNum = startNum+iDisplayLength;  
            }             
        }else {  
            endNum = startNum+iDisplayLength;  
        }
        List<ServiceForm> subList = new ArrayList<>();
        if(list.size() != 0){
        	subList = list.subList(startNum, endNum);
        }
		return subList;
	}


	@Override
	public List<DropDownJd> queryjd(String jddm) {
		// TODO Auto-generated method stub
		List<DropDownJd> result = repairDao.queryjd(jddm);
		return result;
	}


	@Override
	public String modifyjd(ModifyJd modifyjd) {
		Integer num = repairDao.modifyjd(modifyjd);
		return null;
	}


	@Override
	public List<SelectedData> queryProvince() {
		List<SelectedData> result = repairDao.queryProvince();
		return result;
	}

	@Override
	public List<SelectedData> queryCity(String provinceid) {
		List<SelectedData> result = repairDao.queryCity(provinceid);
		return result;
	}

	@Override
	public List<SelectedData> queryDistrict(String cityid) {
		List<SelectedData> result = repairDao.queryDistrict(cityid);
		return result;
	}


	@Override
	public String savePoint(Point point) {
		System.out.println(point);
		String maxid = queryMaxId();
		point.setId(maxid);
		Integer num = repairDao.savePoint(point);
		if(num > 0){
			return "success";
		}else{
			return "failure";
		}
	}
	
	@Override
	public String queryMaxId(){
		Integer maxid = 0;
		Integer result = repairDao.queryMaxId();
		if(result == null){
			maxid = 1;
		}else{
			maxid = result+1;
		}
		return maxid.toString();
		
	}
}
