package com.equipment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equipment.pojo.Province;
import com.equipment.service.yhxt.sbfw.SbfwService;

@Controller
public class SbfwController {
	
	@Autowired
	@Qualifier("SbfwService")
	private SbfwService sbfwservice;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="sbfw/init")
	public String sbfw(Model model){
		System.out.println("这里是设备维修站点查询");
		
		List<Province> prolist = sbfwservice.getAllPro();
		
		request.setAttribute("prolist", prolist);
		System.out.println(prolist);
		
		return "/pages/yhxt/sbfw/sbwxzdcx";
		
	}
}
