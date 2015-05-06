package com.equipment.controller;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.yhxt.Sbjbxx;
import com.equipment.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {

	@Autowired
    @Qualifier("login")
	public LoginService loginService;
	
	@Autowired
	HttpSession session;
	
	ObjectMapper objectMapper =  new ObjectMapper(); 
	
	@RequestMapping(value={"/login","/pages/login/login"})
	public String login(@RequestParam(value="username",required=false)String username,
			@RequestParam(value="password",required=false)String password){
		Map<String,String> result = loginService.login(username,password);
		session.setAttribute("userid", result.get("userid"));
		return result.get("view");
	}
	
	@RequestMapping(value={"/custom","/pages/login/custom"})
	public String customlogin(@RequestParam(value="number",required=false)String number,Model model){
		Sbjbxx result=loginService.customlogin(number);
		session.setAttribute("sbxlh", number);
		
//		System.out.println(session.getAttribute("sbxlh"));
		if(result!=null){
//			model.addAllAttributes((Map<String,?>) result)model;
			model.addAttribute("sbxlh",result.getSbxlh());
			model.addAttribute("sbmc",result.getSbmc());
			model.addAttribute("sbmz",result.getSbmz());
			model.addAttribute("sbxh",result.getSbxh());
			model.addAttribute("sbys",result.getSbys());
			model.addAttribute("sjsj",result.getSjsj());
			session.setAttribute("sblx",result.getSblx());
			return "pages/main/customerMain";
		}else{
			return "pages/login/customerlogin";
		}
		
	}
}
