package com.equipment.controller;

import java.util.Date;
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
import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Fwsqd;
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
	private HttpSession session;

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
	
	@RequestMapping(value="sbwxfw/init")
	public String sbfwsq(Model model){
		List<Province> prolist = sbfwservice.getAllPro();
		List<DmZsly> zslylist = sbfwservice.getAllZsly();
		System.out.println(zslylist);
		System.out.println(session.getAttribute("sbxlh"));
		List<Fwsqd> fwsqdlist = sbfwservice.getAllFwsqd((String)session.getAttribute("sbxlh"));
		System.out.println(fwsqdlist);
		request.setAttribute("fwsqdlist", fwsqdlist);
		request.setAttribute("prolist", prolist);
		request.setAttribute("zslylist", zslylist);
		return "/pages/yhxt/sbfw/sbwxfwsq";
	}
	
	@RequestMapping(value="sbwxfw/shwxfwsqadd")
	public String sbfwsqadd(Fwsqd fwsqd){
		Date da = new Date();
		String sqdbh = Long.toString(da.getTime());
		String sbxlh = (String)session.getAttribute("sbxlh");
		fwsqd.setSqdbh(sqdbh);
		fwsqd.setSbxlh(sbxlh);
		System.out.println(fwsqd);
		fwsqd.setJddm("1");
		sbfwservice.addFwsqd(fwsqd);
		List<Province> prolist = sbfwservice.getAllPro();
		List<DmZsly> zslylist = sbfwservice.getAllZsly();
		System.out.println(zslylist);
		System.out.println(session.getAttribute("sbxlh"));
		List<Fwsqd> fwsqdlist = sbfwservice.getAllFwsqd(sbxlh);
		System.out.println(fwsqdlist);
		request.setAttribute("fwsqdlist", fwsqdlist);
		request.setAttribute("prolist", prolist);
		request.setAttribute("zslylist", zslylist);
		return "/pages/yhxt/sbfw/sbwxfwsq";
	}
	
	@RequestMapping(value="getsqdmx")
	public @ResponseBody Map<String,String> getsqdmx(@RequestParam String sqdbh){
		List<Fwsqd> fwsqdmx = sbfwservice.getSqdmx(sqdbh);
		System.out.println(fwsqdmx);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> model = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(fwsqdmx);
			model.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping(value="addyhpj")
	public @ResponseBody String addyhpj(@RequestParam String sqdbh,@RequestParam String yhpj){
		System.out.println(sqdbh);
		System.out.println(yhpj);
		Fwsqd fwsqd = new Fwsqd();
		fwsqd.setSqdbh(sqdbh);
		fwsqd.setYhpj(yhpj);
		sbfwservice.updateFwsqd(fwsqd);
		return "OK";
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
