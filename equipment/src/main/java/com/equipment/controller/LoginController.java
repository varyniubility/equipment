package com.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.service.LoginService;

@Controller
public class LoginController {

	@Autowired
    @Qualifier("login")
	public LoginService loginService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(value="username",required=false)String username,
			@RequestParam(value="password",required=false)String password){
		String result = loginService.login(username);
		ModelAndView mv = new ModelAndView(result);
		System.out.println(mv);
		return mv;
	}
}
