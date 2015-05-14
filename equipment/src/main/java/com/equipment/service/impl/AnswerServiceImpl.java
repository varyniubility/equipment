package com.equipment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IAnswerDao;
import com.equipment.pojo.Answer;
import com.equipment.pojo.DropDownJd;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionUpdate;
import com.equipment.pojo.ServiceForm;
import com.equipment.service.AnswerService;

@Component
@Service("answer")
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	public IAnswerDao answerDao;
	
	@Override
	public List<Answer> queryQuestion(Question question) {
		List<Answer> answer = answerDao.queryQuestion(question);
		return answer;
	}

	/**
	 * 用于分页获取当前页面需要展示的列表
	 * @param list 原始的全量数据列表
	 * @param iDisplayStart 当前页面开始的数据
	 * @param iDisplayLength 页面展示数据长度
	 * @return List<String>
	 */
	@Override
	public List<Answer> getSubList(List<Answer> list, int iDisplayStart,
			int iDisplayLength) {
		long total = 0;
		int pageCount = 0;
		int remainder = 0;
		int startNum = 0;
		int endNum = 0;
		int curPage = 0;
		total = list.size();
		pageCount = (int) (total/iDisplayLength);  
        remainder = (int) (total%iDisplayLength);
        if(remainder != 0){  
            pageCount = pageCount + 1;  
        }
        curPage = iDisplayStart/iDisplayLength+1;   
        startNum = iDisplayStart;  
        endNum = iDisplayStart + iDisplayLength;  
        startNum = iDisplayLength*(curPage-1); 
        if(remainder != 0){  
            if(curPage == pageCount){  
                endNum = startNum + remainder;  
            }else{  
                endNum = startNum+iDisplayLength;  
            }             
        }else {  
            endNum = startNum+iDisplayLength;  
        }
        List<Answer> subList = new ArrayList<>();
        if(list.size() != 0){
        	subList = list.subList(startNum, endNum);
        }
		return subList;
	}
	
	@Override
	public List<DropDownJd> queryjd(String jddm) {
		// TODO Auto-generated method stub
		List<DropDownJd> result = answerDao.queryjd(jddm);
		return result;
	}

	@Override
	public String modifyQues(QuestionUpdate questionUpdate) {
		Integer num = answerDao.modifyQues(questionUpdate);
		return null;
	}
}
