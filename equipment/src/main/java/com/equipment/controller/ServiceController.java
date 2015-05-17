package com.equipment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.Fwsqd;
import com.equipment.pojo.ResultPojo;
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
	
	@RequestMapping(value="service/initservice")
	public String initService(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/admin/servicemanage";
		}
	}
	
	@RequestMapping(value="service/querysqd")
	public @ResponseBody Map<String,String> queryService(@RequestBody DatatableParams dtp){
		ResultPojo result = serviceService.queryService(dtp);
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
}
