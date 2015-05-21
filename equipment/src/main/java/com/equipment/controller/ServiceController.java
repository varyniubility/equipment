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
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.AddService;
import com.equipment.pojo.ApplyOrder;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.ModifyQuestion;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.UserSelect;
import com.equipment.service.ServiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ServiceController {

	@Autowired
	HttpSession session;
	@Autowired
	@Qualifier("service")
	ServiceService serviceService;

	@RequestMapping(value = "service/initservice")
	public String initService() {
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if (userid == null && username == null) {
			return "redirect:/pages/login/login.jsp";
		} else {
			return "/pages/admin/servicemanage";
		}
	}

	@RequestMapping(value = "service/querysqd")
	public @ResponseBody Map<String, String> queryService(
			@RequestBody DatatableParams dtp) {
		ResultPojo result = serviceService.queryService(dtp);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> model = new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);
			model.put("list", json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "service/queryprovince")
	public @ResponseBody Map<String, String> queryProvince() {
		List<SelectedData> result = serviceService.queryProvince();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}

	@RequestMapping(value = "service/querycity")
	public @ResponseBody Map<String, String> queryCity(
			@RequestBody String provinceid) {
		List<SelectedData> result = serviceService.queryCity(provinceid);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}

	@RequestMapping(value = "service/querydistrict")
	public @ResponseBody Map<String, String> queryDistrict(
			@RequestBody String cityid) {
		List<SelectedData> result = serviceService.queryDistrict(cityid);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}

	@RequestMapping(value = "service/queryengineer")
	public @ResponseBody Map<String, String> queryEngineer() {
		List<SelectedData> result = serviceService.queryEngineer();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}

	@RequestMapping(value = "service/queryadmin")
	public @ResponseBody Map<String, String> queryAdmin() {
		List<SelectedData> result = serviceService.queryAdmin();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}
	
	@RequestMapping(value = "service/queryjd")
	public @ResponseBody Map<String, String> queryJd() {
		List<SelectedData> result = serviceService.queryJd();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}
	
	@RequestMapping(value = "service/savesqd")
	public @ResponseBody Map<String, String> saveOrder(@RequestBody ApplyOrder applyOrder) {
		String result = serviceService.saveOrder(applyOrder);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}
}
