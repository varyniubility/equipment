package com.equipment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyQuestion;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class QuestionController {

	@Autowired
	HttpSession session;
	
	@Autowired
	@Qualifier("question")
	QuestionService questionService;
	
	@RequestMapping(value="question/initquestion")
	public String initQuestion(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/admin/quesmanage";
		}
	}
	
	@RequestMapping(value="question/query")
	public @ResponseBody Map<String,String> queryQuestion(@RequestBody DatatableParams dtparam){
		ResultPojo result = questionService.queryQuestion(dtparam);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="question/querygcs")
	public @ResponseBody Map<String,String> queryGcs(){
		List<SelectedData> result = questionService.queryGcs();
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resMap);
		return resMap;
	}
	
	@RequestMapping(value="question/modifyques")
	public @ResponseBody Map<String,String> modifyQues(@RequestBody ModifyQuestion mq){
		String result = questionService.modifyQues(mq);
		ObjectMapper objectmaper = new ObjectMapper();
		Map<String, String> resMap = new HashMap<String, String>();
		String  json;
		try {
			json = objectmaper.writeValueAsString(result);
			resMap.put("list", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resMap);
		return resMap;
	}
	
}
