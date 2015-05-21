package com.equipment.service;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyQuestion;
import com.equipment.pojo.ResultPojo;
import com.equipment.pojo.SelectedData;

public interface QuestionService {

	ResultPojo queryQuestion(DatatableParams dtparam);

	List<SelectedData> queryGcs();

	String modifyQues(ModifyQuestion mq);

}
