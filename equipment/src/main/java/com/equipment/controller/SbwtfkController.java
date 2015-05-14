package com.equipment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.DmZsly;
import com.equipment.pojo.Sbwtfk;
import com.equipment.service.yhxt.sbwtfk.SbwtfkService;

@Controller
public class SbwtfkController {
	@Autowired
	@Qualifier("SbwtfkService")
	private SbwtfkService sbwtfkservice;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value ="/sbwtfk")
	public String sbwtfk(String sbxlh, Model model) {
		System.out.println("执行了设备问题反馈");
		if (sbxlh.equals("0")) {
			sbxlh = session.getAttribute("sbxlh").toString();
		}
		List<Sbwtfk> sbwtlist = sbwtfkservice.getsbwtfk(sbxlh);
		List<DmZsly> zslylist = sbwtfkservice.getzsly();
		
		request.setAttribute("zslylist", zslylist);
		request.setAttribute("sbwtlist", sbwtlist);
		String seiralNo = (String) session.getAttribute("seiralno");
		if(seiralNo==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/yhxt/sbwtfk/sbwtfk";
		}
	}
	
	
	@RequestMapping(value="/addsbwt")
	public String addsbwt(Sbwtfk sbwtfk,Model model){
		
		Date date = new Date();
		sbwtfk.setJddm("01");
		sbwtfk.setWtbh(Long.toString(date.getTime()));
		sbwtfk.setSbxlh(session.getAttribute("sbxlh").toString());
		System.out.println(date.getTime());
		System.out.println(sbwtfk.getSbwt());
		sbwtfkservice.insertzsly(sbwtfk);
		
		
		List<Sbwtfk> sbwtlist = sbwtfkservice.getsbwtfk(session.getAttribute("sbxlh").toString());
		List<DmZsly> zslylist = sbwtfkservice.getzsly();
		
		request.setAttribute("zslylist", zslylist);
		request.setAttribute("sbwtlist", sbwtlist);
		
		return "pages/yhxt/sbwtfk/sbwtfk";
	}
	
	@RequestMapping(value="updatewtpj")
	public String updatewtpj(Sbwtfk sbwtfk,Model model){
		
		System.out.println(sbwtfk);
		sbwtfkservice.updatewtpj(sbwtfk);
		List<Sbwtfk> sbwtlist = sbwtfkservice.getsbwtfk(session.getAttribute("sbxlh").toString());
		List<DmZsly> zslylist = sbwtfkservice.getzsly();
		
		request.setAttribute("zslylist", zslylist);
		request.setAttribute("sbwtlist", sbwtlist);
		
		return "pages/yhxt/sbwtfk/sbwtfk";
	}
}
