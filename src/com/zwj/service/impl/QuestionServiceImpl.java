package com.zwj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwj.dao.QuestionDao;
import com.zwj.model.CheckQuestions;
import com.zwj.model.RadioQuestions;
import com.zwj.model.Subject;
import com.zwj.service.QuestionService;

@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService {
@Autowired
private QuestionDao questionDao;

@Override
public int addRaQuestion(RadioQuestions radioQuestions) {
	// TODO Auto-generated method stub
	return questionDao.addRaQuestion(radioQuestions);
}

@Override
public List<RadioQuestions> getRaQuestions(int subId) {
	// TODO Auto-generated method stub
	List<RadioQuestions> radioList=questionDao.getRaQuestions(subId);
	return radioList;
}

@Override
public int addChQuestion(CheckQuestions checkQuestions) {
	// TODO Auto-generated method stub
	return questionDao.addChQuestion(checkQuestions);
}

@Override
public List<CheckQuestions> getChQuestions(int id) {
	// TODO Auto-generated method stub
	List<CheckQuestions> checkList=questionDao.getChQuestions(id);
	return checkList;
}

@Override
public int delRaQuestions(int radioId) {
	// TODO Auto-generated method stub
	return questionDao.delRaQuestions(radioId);
}

@Override
public int delchQuestions(int checkId) {
	// TODO Auto-generated method stub
	return questionDao.delchQuestions(checkId);
}

@Override
public List<RadioQuestions> getRaQuestionById(int id) {
	// TODO Auto-generated method stub
	return questionDao.getRaQuestionById(id);
}

@Override
public List<CheckQuestions> getChQuestionById(int id) {
	// TODO Auto-generated method stub
	return questionDao.getChQuestionById(id);
}

@Override
public void updateRaQuestion(RadioQuestions radisQuestions) {
	// TODO Auto-generated method stub
	questionDao.updateRaQuestion(radisQuestions);
}

@Override
public void updateChQuestion(CheckQuestions checkQuestions) {
	// TODO Auto-generated method stub
	questionDao.updateChQuestion(checkQuestions);
}

@Override
public List<Subject> getAllsub() {
	// TODO Auto-generated method stub
	return questionDao.getAllsub();
}

@Override
public String getSubName(String subId) {
	// TODO Auto-generated method stub
	return questionDao.getSubName(subId);
}

}
