package com.equipment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equipment.pojo.yhxt.Sbjbxx;
import com.equipment.service.yhxt.sbjbxx.SbjbxxService;

@Controller
public class YhxtInfoController {
	@Autowired
	@Qualifier("SbjbxxService")
	private SbjbxxService sbjbxxservice;

	@Autowired
	HttpSession session;
	@RequestMapping(value ="/sbjbxx")
	public String sbjbxx(String sbxlh, Model model) {
		System.out.println("执行了"+sbxlh);
		if (sbxlh.equals("0")) {
			//sbxlh = request.getAttribute("sbxlh").toString();
			sbxlh = session.getAttribute("sbxlh").toString();
			System.out.println(sbxlh);
		}
		Sbjbxx sbjbxx = sbjbxxservice.getsbjbxx(sbxlh);
		if (sbjbxx != null) {
			model.addAttribute("sbxlh", sbjbxx.getSbxlh());
			model.addAttribute("sbmc", sbjbxx.getSbmc());
			model.addAttribute("sbmz", sbjbxx.getSbmz());
			model.addAttribute("sbxh", sbjbxx.getSbxh());
			model.addAttribute("sbys", sbjbxx.getSbys());
			model.addAttribute("sjsj", sbjbxx.getSjsj());
		}
		// model.addAllAttributes(sbjbxx);

		// String vie = "/equipment/pages/yhxt/sbjbxx/sbjbxx.jsp";
		// return new ModelAndView(new RedirectView(vie),(Map<String, ?>)
		// model);
		System.out.println(model);
		System.out.println("获取成功，返回sbjbxx");
		return "pages/yhxt/sbjbxx/sbjbxx";
//		return "pages/main/customerMain";
	}
}
