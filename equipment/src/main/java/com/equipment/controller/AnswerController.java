package com.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerController {

	@RequestMapping(value="answer/init")
	public String initBaseInfo(){
		return "/pages/engineer/answer";
	}
}
