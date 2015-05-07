package com.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.ModifyPassword;
import com.equipment.service.BaseInfoService;

@Controller
public class BaseInfoController {

	@Autowired
    @Qualifier("baseinfo")
	public BaseInfoService baseInfoService;
	
	@RequestMapping(value="baseinfo/modifyinfo")
	public String initModifyInfo(){
		return "/pages/engineer/modifyinfo";
	}
	
	@RequestMapping(value="baseinfo/modifypassword")
	public String initmodifypassword(){
		return "/pages/engineer/modifypwd";
	}
	
	@RequestMapping(value="baseinfo/baseinfo")
	public BaseInfo modifyBaseInfo(@RequestParam(value="oldpassword",required=false)String oldpassword,
			@RequestParam(value="newpassword",required=false)String newpassword,
			@RequestParam(value="confirmpwd",required=false)String confirmpwd){
		
		return null;
	}
	
	@RequestMapping(value="baseinfo/password")
	@ResponseBody
	public BaseInfo modifyPassword(@RequestBody ModifyPassword modifyPassword){
		String userid = modifyPassword.getUserid();
		String oldpassword = modifyPassword.getOldpassword();
		String newpassword = modifyPassword.getNewpassword();
		String confirmpwd = modifyPassword.getConfirmpwd();
		System.out.println(confirmpwd);
		String s = baseInfoService.modifyPassword(oldpassword, newpassword, confirmpwd, userid);
		return null;
	}
}
