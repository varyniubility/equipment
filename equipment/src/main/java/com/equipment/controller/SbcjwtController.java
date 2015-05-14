package com.equipment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.Sbcjwt;
import com.equipment.service.yhxt.sbcjwt.SbcjwtService;

@Controller
public class SbcjwtController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	@Qualifier("SbcjwtService")
	private SbcjwtService sbcjwtservice;
	
	
	
	@RequestMapping(value="/sbcjwt")
	public String sbcjwt(@RequestParam(value="sblx")String sblx,Model model){
		if(sblx.equals("0")){
			sblx=(String) session.getAttribute("sblx");
		}
		List<Sbcjwt> sbcjwtlist = sbcjwtservice.getsbcjwt(sblx);
//		System.out.println("sbcjwtlist的大小："+sbcjwtlist.size());
//		int len = sbcjwtlist.size();
		/*for(int i=0;i<len;i++){
			modellist.get(i).addAttribute("cjwt",sbcjwtlist.get(i).getCjwt() );
			modellist.get(i).addAttribute("cjwtjd",sbcjwtlist.get(i).getCjwtjd() );
		}*/
//		model.addAttribute("sbcjwtlist", sbcjwtlist);
		request.setAttribute("wtlist", sbcjwtlist);
//		sbcjwtlist = (List<Sbcjwt>) model.asMap().get("sbcjwlist");
//		System.out.println(modellist);
		
		String seiralNo = (String) session.getAttribute("seiralno");
		if(seiralNo==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/yhxt/sbcjwt/sbcjwt";
		}
	}
}
