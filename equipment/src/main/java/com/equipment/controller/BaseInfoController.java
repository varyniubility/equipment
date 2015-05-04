package com.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.QueryParams;

@Controller
public class BaseInfoController {

	@RequestMapping(value="baseinfo/modifyinfo")
	public String initModifyInfo(){
		return "/pages/engineer/modifyinfo";
	}
	
	@RequestMapping(value="baseinfo/modifypassword")
	public String initmodifypassword(){
		return "/pages/engineer/modifypwd";
	}
	
	@RequestMapping(value="/query")
	public BaseInfo queryBaseInfo(@ModelAttribute QueryParams queryParams){
		System.out.println(queryParams);
		return null;
	}
}
