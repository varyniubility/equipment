package com.equipment.dao;

import java.util.List;

import com.equipment.pojo.DatatableParams;
import com.equipment.pojo.ModifyQuestion;
import com.equipment.pojo.Question;
import com.equipment.pojo.QuestionResult;
import com.equipment.pojo.SelectedData;
import com.equipment.utils.MyBatisRepository;

@MyBatisRepository
public interface IQuestionDao {

	List<QuestionResult> queryQuestion(DatatableParams dtparam);

	List<SelectedData> queryGcs();

	Integer modifyQues(ModifyQuestion mq);

}
