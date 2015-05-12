package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.Answer;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionUpdate;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IAnswerDao {

	public List<Answer> queryQuestion(Question question);
	
	public List<DropDownJd> queryjd(String jddm);

	public Integer modifyQues(QuestionUpdate questionUpdate);

}
