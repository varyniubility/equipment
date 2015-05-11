package com.equipment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.ModifyPassword;
import com.equipment.pojo.SelectedData;
import com.equipment.service.BaseInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BaseInfoController {

	@Autowired
    @Qualifier("baseinfo")
	public BaseInfoService baseInfoService;
	
	@RequestMapping(value="baseinfo/modifyinfo")
	public @ResponseBody ModelAndView initModifyInfo(){
		return new ModelAndView("/pages/engineer/modifyinfo");
	}
	
	@RequestMapping(value="baseinfo/queryInfo")
	public @ResponseBody Map<String,Object> queryInfo(@RequestBody String userid){
		System.out.println(userid);
		BaseInfo info = baseInfoService.queryInfo(userid);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,Object> resMap = new HashMap<>();
		String infojson;
		try {
			infojson = objectMapper.writeValueAsString(info);
			resMap.put("info", infojson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resMap;
	}
	@RequestMapping(value="baseinfo/modifypassword")
	public String initmodifypassword(){
		return "/pages/engineer/modifypwd";
	}
	
	@RequestMapping(value="baseinfo/queryprovince")
	public @ResponseBody Map<String,String> queryProvince(){
		List<SelectedData> result = baseInfoService.queryProvince();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resMap);
		return resMap;
	}
	
	@RequestMapping(value="baseinfo/querycity")
	public @ResponseBody Map<String,String> queryCity(@RequestBody String provinceid){
		List<SelectedData> result = baseInfoService.queryCity(provinceid);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resMap);
		return resMap;
	}
	
	@RequestMapping(value="baseinfo/querydistrict")
	public @ResponseBody Map<String,String> queryDistrict(@RequestBody String cityid){
		List<SelectedData> result = baseInfoService.queryDistrict(cityid);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resMap);
		return resMap;
	}
	
	@RequestMapping(value="baseinfo/savemodify")
	public @ResponseBody Map<String,String> saveModify(@RequestBody BaseInfo baseInfo){
		List<BaseInfo> result = baseInfoService.saveModify(baseInfo);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}
	
	@RequestMapping(value="baseinfo/password")
	@ResponseBody
	public String modifyPassword(@RequestBody ModifyPassword modifyPassword){
		String userid = modifyPassword.getUserid();
		String oldpassword = modifyPassword.getOldpassword();
		String newpassword = modifyPassword.getNewpassword();
		String confirmpwd = modifyPassword.getConfirmpwd();
		String s = baseInfoService.modifyPassword(oldpassword, newpassword, confirmpwd, userid);
		return null;
	}
}
