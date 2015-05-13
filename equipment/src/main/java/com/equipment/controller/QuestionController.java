package com.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {

	@RequestMapping(value="question/initquestion")
	public @ResponseBody ModelAndView initQuestion(){
		System.out.println("asdfasf");
		return new ModelAndView("/pages/admin/quesmanage");
	}
}
