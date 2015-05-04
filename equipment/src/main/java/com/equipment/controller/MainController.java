package com.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="main/init")
	public String initRepair(){
		return "/pages/main/engineerMain";	
	}
}
