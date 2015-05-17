package com.equipment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.AdminInfo;
import com.equipment.pojo.ModifyPassword;
import com.equipment.pojo.SelectedData;
import com.equipment.service.AdminInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminInfoController {

	@Autowired
    @Qualifier("admininfo")
	public AdminInfoService adminInfoService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="admininfo/initmodifyinfo")
	public String initModifyInfo(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "/pages/login/login";
		}else{
			return "/pages/admin/modifyinfo";
		}
	}
	
	@RequestMapping(value="admininfo/initmodifypwd")
	public String initModifyPwd(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/admin/modifypwd";
		}
	}
	
	@RequestMapping(value="admininfo/queryInfo")
	public @ResponseBody Map<String,Object> queryInfo(@RequestBody String userid){
		System.out.println(userid);
		AdminInfo info = adminInfoService.queryInfo(userid);
		System.out.println(userid);
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
	
	@RequestMapping(value="admininfo/queryprovince")
	public @ResponseBody Map<String,String> queryProvince(){
		List<SelectedData> result = adminInfoService.queryProvince();
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
	
	@RequestMapping(value="admininfo/querycity")
	public @ResponseBody Map<String,String> queryCity(@RequestBody String provinceid){
		List<SelectedData> result = adminInfoService.queryCity(provinceid);
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
	
	@RequestMapping(value="admininfo/querydistrict")
	public @ResponseBody Map<String,String> queryDistrict(@RequestBody String cityid){
		List<SelectedData> result = adminInfoService.queryDistrict(cityid);
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
	
	@RequestMapping(value="admininfo/savemodify")
	public @ResponseBody Map<String,String> saveModify(@RequestBody AdminInfo adminInfo){
		String result = adminInfoService.saveModify(adminInfo);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("result", json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	@RequestMapping(value="admininfo/password")
	@ResponseBody
	public Map<String, String> modifyPassword(@RequestBody ModifyPassword modifyPassword){
		String userid = modifyPassword.getUserid();
		String oldpassword = modifyPassword.getOldpassword();
		String newpassword = modifyPassword.getNewpassword();
		String confirmpwd = modifyPassword.getConfirmpwd();
		String result = adminInfoService.modifyPassword(oldpassword, newpassword, confirmpwd, userid);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("result", json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resMap;
	}
}
