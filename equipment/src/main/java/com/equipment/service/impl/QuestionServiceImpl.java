package com.equipment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.equipment.dao.IQuestionDao;
import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyQuestion;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionResult;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;
import com.equipment.pojo.ServiceForm;
import com.equipment.service.QuestionService;

@Component
@Service("question")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	IQuestionDao questionDao;
	
	@Override
	public ResultPojo queryQuestion(DatatableParams dtparam) {
		List<QuestionResult> result = questionDao.queryQuestion(dtparam);
		int count = 0;
		int sEcho = dtparam.getsEcho();
		int iDisplayStart = dtparam.getiDisplayStart();
		int iDisplayLength = dtparam.getiDisplayLength();
		List<QuestionResult> subList = getSubList(result,iDisplayStart,iDisplayLength);
		String obj1[][] = new String[subList.size()][13];
	    for(QuestionResult w:subList){
	    	obj1[count][0] = "";
	    	obj1[count][1] = w.getSbmc();
	    	obj1[count][2] = w.getSbxh();
	    	obj1[count][3] = w.getSbys();
	    	obj1[count][4] = w.getSbwt();
	    	obj1[count][5] = w.getGlyxm();
	    	obj1[count][6] = w.getGcsxm();
	    	obj1[count][7] = w.getYhpj();
	    	obj1[count][8] = w.getGcszj();
	    	obj1[count][9] = w.getWxjd();
	    	obj1[count][10] = w.getGlydm();
	    	obj1[count][11] = w.getGcsdm();
	    	obj1[count][12] = w.getWtbh();
			count++;
	    }
		ResultPojo res = new ResultPojo();
		res.setAaData(obj1);
		res.setiTotalDisplayRecords(result.size());
		res.setiTotalRecords(result.size());
		res.setsEcho(sEcho);
		return res;
	}
	
	/**
	 * 用于分页获取当前页面需要展示的列表
	 * @param list 原始的全量数据列表
	 * @param iDisplayStart 当前页面开始的数据
	 * @param iDisplayLength 页面展示数据长度
	 * @return List<String>
	 */
	private List<QuestionResult> getSubList(List<QuestionResult> list,int iDisplayStart,int iDisplayLength){
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
        List<QuestionResult> subList = new ArrayList<>();
        if(list.size() != 0){
        	subList = list.subList(startNum, endNum);
        }
		return subList;
	}

	@Override
	public List<SelectedData> queryGcs() {
		List<SelectedData> result = questionDao.queryGcs();
		return result;
	}

	@Override
	public String modifyQues(ModifyQuestion mq) {
		System.out.println(mq);
		Integer result = questionDao.modifyQues(mq);
		return null;
	}


}
