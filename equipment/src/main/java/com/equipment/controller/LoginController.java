package com.equipment.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.equipment.pojo.Sbjbxx;
import com.equipment.service.LoginService;

@Controller
public class LoginController {

	@Autowired
    @Qualifier("login")
	public LoginService loginService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value={"/login","/pages/login/login"})
	public String login(@RequestParam(value="username",required=false)String username,
			@RequestParam(value="password",required=false)String password){
		String result = loginService.login(username,password);
		return result;
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
			model.addAttribute("sblx", result.getSblx());
//			System.out.println(model.toString());
			session.setAttribute("sblx",result.getSblx());
			request.setAttribute("style", "1");
			return "pages/main/customerMain";
		}else{
			return "pages/login/customerlogin";
		}
		
	}
}
