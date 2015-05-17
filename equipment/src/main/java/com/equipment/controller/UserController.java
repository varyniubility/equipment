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
import org.springframework.web.bind.annotation.ResponseBody;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.UserInfo;
import com.equipment.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	@Autowired
	HttpSession session;
	
	@Autowired
    @Qualifier("user")
	public UserService userService;
	
	@RequestMapping(value="user/inituser")
	public String initUser(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/admin/usermanage";
		}
	}
	
	@RequestMapping(value="user/queryuser")
	public @ResponseBody Map<String,String> queryUser(@RequestBody DatatableParams dtparam){
		ResultPojo result = userService.queryUser(dtparam);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="user/queryprovince")
	public @ResponseBody Map<String,String> queryProvince(){
		List<SelectedData> result = userService.queryProvince();
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
	
	@RequestMapping(value="user/querycity")
	public @ResponseBody Map<String,String> queryCity(@RequestBody String provinceid){
		List<SelectedData> result = userService.queryCity(provinceid);
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
	
	@RequestMapping(value="user/querydistrict")
	public @ResponseBody Map<String,String> queryDistrict(@RequestBody String cityid){
		List<SelectedData> result = userService.queryDistrict(cityid);
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
	
	@RequestMapping(value="user/adduser")
	public @ResponseBody Map<String,String> addUser(@RequestBody UserInfo userInfo){
		String result = userService.addUser(userInfo);
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
	
	@RequestMapping(value="user/modifyuser")
	public @ResponseBody Map<String,String> modifyUser(@RequestBody UserInfo userInfo){
		String result = userService.modifyUser(userInfo);
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
	
	@RequestMapping(value="user/deleteuser")
	public @ResponseBody Map<String,String> deleteUser(@RequestBody String userid){
		String result = userService.deleteUser(userid);
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
