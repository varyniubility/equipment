package com.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equipment.service.RepairService;

@Controller
public class RepairController {

	@Autowired
	@Qualifier("repair")
	public RepairService repairService;
	
	@RequestMapping(value="repair/init")
	public String initRepair(){
		System.out.println("sfasfds");
		return "/pages/engineer/repairequip";	
	}
}
