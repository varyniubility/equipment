package com.equipment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.ServiceForm;
import com.equipment.service.RepairService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class RepairController {

	@Autowired
	@Qualifier("repair")
	public RepairService repairService;
	
	@RequestMapping(value="repair/init")
	public String initRepair(){
		return "/pages/engineer/repairequip";	
	}
	
	@RequestMapping(value="repair/query")
	public @ResponseBody Map<String,String> queryService(@RequestBody DatatableParams dtparam){
		ResultPojo result = repairService.queryService(dtparam);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);;
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="repair/queryjd")
	public @ResponseBody Map<String,String> queryjd(@RequestBody String jddm){
		List<DropDownJd> result = repairService.queryjd(jddm);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);;
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="repair/modifyjd")
	public @ResponseBody Map<String,String> modifyjd(@RequestBody ModifyJd modifyjd){
		System.out.println(modifyjd);
		String result = repairService.modifyjd(modifyjd);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);;
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
}
