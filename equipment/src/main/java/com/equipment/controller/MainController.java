package com.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="main/initEngineer")
	public String initEngineerMain(){
		return "/pages/main/engineerMain";	
	}
	
	@RequestMapping(value="main/initAdmin")
	public String initAdminMain(){
		return "/pages/main/adminMain";	
	}
}
