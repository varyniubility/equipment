package com.equipment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	HttpSession session;
	
	@RequestMapping(value="main/initEngineer")
	public String initEngineerMain(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/main/engineerMain";	
		}
	}
	
	@RequestMapping(value="main/initAdmin")
	public String initAdminMain(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/main/adminMain";
		}
	}
}
