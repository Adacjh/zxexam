package com.zwj.dao;

import java.util.List;

import com.zwj.model.CheckQuestions;
import com.zwj.model.RadioQuestions;
import com.zwj.model.SubjectTest;
import com.zwj.model.ZuJuan;



public interface ZujuanDao {

	List<RadioQuestions> setRaQuestionTest(int number,int difficult, int subName);

	List<CheckQuestions> setCkQuestionTest(int number,int difficult, int subName);

	int addZujuanRadio(ZuJuan zujuan1);

	int addZujuanCheck(ZuJuan zujuan1);

	void addSubTest(SubjectTest subjectTest);

	List<SubjectTest> zujuanInfo();

	List<ZuJuan> subTestInfo(ZuJuan zuJuan);

	List<ZuJuan> subTestInfo1(ZuJuan zuJuan);

	void delTestInfo(int id);

	

	

}
