package com.equipment.service;

import java.util.List;

import com.equipment.pojo.Answer;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionUpdate;

public interface AnswerService {

	public List<Answer> queryQuestion(Question question);
	
	public List<Answer> getSubList(List<Answer> list,int iDisplayStart,int iDisplayLength);
	
	public List<DropDownJd> queryjd(String jddm);

	public String modifyQues(QuestionUpdate questionUpdate);

}
