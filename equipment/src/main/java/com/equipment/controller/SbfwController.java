package com.equipment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.City;
import com.equipment.pojo.District;
import com.equipment.pojo.PointData;
import com.equipment.pojo.Province;
import com.equipment.pojo.QueryPoint;
import com.equipment.service.yhxt.sbfw.SbfwService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SbfwController {

	@Autowired
	@Qualifier("SbfwService")
	private SbfwService sbfwservice;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "sbfw/init")
	public String sbfw(Model model) {
		List<Province> prolist = sbfwservice.getAllPro();
		request.setAttribute("prolist", prolist);
		String seiralNo = (String) session.getAttribute("seiralno");
		if(seiralNo==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/yhxt/sbfw/sbwxzdcx";
		}

	}

	/**
	 * 通过省id获取城市信息
	 * 
	 * @return model
	 */
	@RequestMapping(value = "querycity")
	public @ResponseBody Map<String, String> getcity(@RequestParam String proid) {
		System.out.println("ajax查询城市");
		List<City> list = sbfwservice.getCityByProId(proid);
		System.out.println(list);

		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> model = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(list);
			model.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}
	
	/**
	 * 根据城市id获取地区信息
	 * disid 地区id
	 * @return model
	 */
	@RequestMapping(value="querydistrict")
	public @ResponseBody Map<String,String> getdistrict(@RequestParam String cityid){
		System.out.println("ajax查询地区");
		List<District> list  = sbfwservice.getDistinctByCityId(cityid);
		System.out.println(list);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String,String> result = new HashMap<String,String>();
		String json;
		
		try {
			json = objectmaper.writeValueAsString(list);
			result.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@RequestMapping(value="sbfw/querypoint")
	public @ResponseBody Map<String,String> queryPoint(@RequestBody QueryPoint queryPoint){
		System.out.println(queryPoint);
		List<PointData> list  = sbfwservice.queryPoint(queryPoint);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String,String> result = new HashMap<String,String>();
		String json;
		
		try {
			json = objectmaper.writeValueAsString(list);
			result.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
