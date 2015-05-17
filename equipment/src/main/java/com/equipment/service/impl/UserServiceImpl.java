package com.equipment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IUserDao;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.ServiceForm;
import com.equipment.pojo.UserInfo;
import com.equipment.service.UserService;
import com.equipment.utils.MD5;

@Component
@Service("user")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public ResultPojo queryUser(DatatableParams dtparam){
		System.out.println(dtparam);
		int count = 0;
		int sEcho = dtparam.getsEcho();
		int iDisplayStart = dtparam.getiDisplayStart();
		int iDisplayLength = dtparam.getiDisplayLength();
		List<UserInfo> result = userDao.queryUser(dtparam);
		List<UserInfo> subList = getSubList(result,iDisplayStart,iDisplayLength);
		String obj1[][] = new String[subList.size()][12];
	    for(UserInfo w:subList){
	    	obj1[count][1] = w.getYhxm();
	    	obj1[count][2] = w.getYhxb();
	    	obj1[count][3] = w.getYhdh();
	    	obj1[count][4] = w.getYhdz();
	    	obj1[count][5] = w.getYhm();
	    	obj1[count][6] = w.getYhlb();
	    	obj1[count][7] = w.getDistrictid();
	    	obj1[count][8] = w.getCityid();
	    	obj1[count][9] = w.getProvinceid();
	    	obj1[count][10] = w.getYhdm();
	    	obj1[count][11] = w.getXxdz();
			count++;
	    }
		ResultPojo res = new ResultPojo();
		res.setAaData(obj1);
		res.setiTotalDisplayRecords(result.size());
		res.setiTotalRecords(result.size());
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
	private List<UserInfo> getSubList(List<UserInfo> list,int iDisplayStart,int iDisplayLength){
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
        List<UserInfo> subList = new ArrayList<>();
        if(list.size() != 0){
        	subList = list.subList(startNum, endNum);
        }
		return subList;
	}

	@Override
	public List<SelectedData> queryProvince() {
		List<SelectedData> result = userDao.queryProvince();
		return result;
	}

	@Override
	public List<SelectedData> queryCity(String provinceid) {
		List<SelectedData> result = userDao.queryCity(provinceid);
		return result;
	}

	@Override
	public List<SelectedData> queryDistrict(String cityid) {
		List<SelectedData> result = userDao.queryDistrict(cityid);
		return result;
	}

	@Override
	public String addUser(UserInfo userInfo) {
		String initPwd = "123456";
		String maxid = queryMaxId();
		String result="";
		MD5 md5 = new MD5();
		String password = md5.GetMD5Code(initPwd);
		userInfo.setYhdm(maxid);
		userInfo.setPassword(password);
		Integer num = userDao.addUser(userInfo);
		Integer num1 = userDao.addUserInfo(userInfo);
		if(num > 0 && num1 <= 0){   //users表插入成功，userinfo表插入失败，回滚users表
			userDao.deleteUser(maxid);
			result = "fail";
		}else if(num <= 0 && num1 <= 0){   //users和UserInfo表同时插入失败，不需要回滚，直接返回出错
			result = "fail";
		}else if(num <= 0 && num1 > 0){   //user表插入失败，userinfo表插入成功，回滚user表
			userDao.deleteUserInfo(maxid);
			result = "fail";
		}else{
			result = "success";
		}
		return result;
	}

	@Override
	public String queryMaxId(){
		String maxid = userDao.queryMaxId();
		Integer newMax = 0;
		if(maxid == null || maxid.equals("")){
			newMax = 1;
		}else{
			Integer max = Integer.parseInt(maxid);
			newMax = max+1;
		}
		return newMax.toString();
	}

	@Override
	public String deleteUser(String userid) {
		String result="";
		Integer num = userDao.deleteUser(userid);
		Integer num1 = userDao.deleteUserInfo(userid);
		if(num > 0 && num1 <= 0){   //users表插入成功，userinfo表插入失败，回滚users表
			userDao.deleteUserInfo(userid);
			result = "success";
		}else if(num <= 0 && num1 <= 0){   //users和UserInfo表同时插入失败，不需要回滚，直接返回出错
			result = "fail";
		}else if(num <= 0 && num1 > 0){   //user表插入失败，userinfo表插入成功，回滚user表
			userDao.deleteUser(userid);
			result = "success";
		}else{
			result = "success";
		}
		return result;
	}

	@Override
	public String modifyUser(UserInfo userInfo) {
		String result="";
		Integer num = userDao.modifyUser(userInfo);
		Integer num1 = userDao.modifyUserInfo(userInfo);
		if(num > 0 && num1 <= 0){   //users表插入成功，userinfo表插入失败，回滚users表
			userDao.modifyUser(userInfo);
			result = "fail";
		}else if(num <= 0 && num1 <= 0){   //users和UserInfo表同时插入失败，不需要回滚，直接返回出错
			result = "fail";
		}else if(num <= 0 && num1 > 0){   //user表插入失败，userinfo表插入成功，回滚user表
			userDao.modifyUserInfo(userInfo);
			result = "fail";
		}else{
			result = "success";
		}
		return result;
	}
}
