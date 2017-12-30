package com.zwj.dao;

import java.util.List;

import com.zwj.model.CheckQuestions;
import com.zwj.model.RadioQuestions;
import com.zwj.model.Subject;

public interface QuestionDao {

	int addRaQuestion(RadioQuestions radioQuestions);

	List<RadioQuestions> getRaQuestions(int subId);

	int addChQuestion(CheckQuestions checkQuestions);

	List<CheckQuestions> getChQuestions(int id);

	int delRaQuestions(int radioId);

	int delchQuestions(int checkId);

	List<RadioQuestions> getRaQuestionById(int id);

	List<CheckQuestions> getChQuestionById(int id);

	void updateRaQuestion(RadioQuestions radisQuestions);

	void updateChQuestion(CheckQuestions checkQuestions);

	List<Subject> getAllsub();

	String getSubName(String subId);


}
