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

import com.equipment.pojo.Answer;
import com.equipment.pojo.BaseInfo;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.ModifyJd;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionUpdate;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.ServiceForm;
import com.equipment.service.AnswerService;
import com.equipment.service.BaseInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AnswerController {

	@Autowired
    @Qualifier("answer")
	public AnswerService answerService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="answer/init")
	public String initBaseInfo(){
		String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		if(userid==null && username==null){
			return "redirect:/pages/login/login.jsp";
		}else{
			return "/pages/engineer/answer";
		}
	}
	
	@RequestMapping(value="answer/query")
	public @ResponseBody Map<String,String> answerQues(@RequestBody Question question){
		int count  = 0;
		int sEcho = question.getsEcho();
		int iDisplayStart = question.getiDisplayStart();
		int iDisplayLength = question.getiDisplayLength();
		List<Answer> resultList = answerService.queryQuestion(question);
		List<Answer> subList = answerService.getSubList(resultList, iDisplayStart, iDisplayLength);
		String obj1[][] = new String[subList.size()][13];
	    for(Answer w:subList){
	    	obj1[count][0] = w.getSbmc();
	    	obj1[count][1] = w.getSbxh();
	    	obj1[count][2] = w.getSbys();
	    	obj1[count][3] = w.getSblx();
	    	obj1[count][4] = w.getSbwt();
	    	obj1[count][5] = w.getSbwtjd();
	    	obj1[count][6] = w.getZsly1();
	    	obj1[count][7] = w.getZsly2();
	    	obj1[count][8] = w.getZsly3();
	    	obj1[count][9] = w.getJdjd();
	    	obj1[count][10] = w.getGcszj();
	    	obj1[count][11] = w.getJddm();
	    	obj1[count][12] = w.getWtbh();
			count++;
	    }
		ResultPojo res = new ResultPojo();
		res.setAaData(obj1);
		res.setiTotalDisplayRecords(resultList.size());
		res.setiTotalRecords(resultList.size());
		res.setsEcho(sEcho);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> resMap =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(res);
			resMap.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	@RequestMapping(value="answer/queryjd")
	public @ResponseBody Map<String,String> queryjd(@RequestBody String jddm){
		List<DropDownJd> result = answerService.queryjd(jddm);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);;
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="answer/modifyques")
	public @ResponseBody Map<String,String> modifyQues(@RequestBody QuestionUpdate questionUpdate){
		System.out.println(questionUpdate);
		String result = answerService.modifyQues(questionUpdate);
		ObjectMapper objectMapper =  new ObjectMapper(); 
		Map<String,String> model =new HashMap<>();
		String json;
		try {
			json = objectMapper.writeValueAsString(result);;
			model.put("list",json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return model;
	}
}
