package com.zwj.dao;

import java.util.List;

import com.zwj.model.Score;
import com.zwj.model.SubjectTest;
import com.zwj.model.Test;
import com.zwj.model.TestInfo;
import com.zwj.model.User;
import com.zwj.model.ZuJuan;


public interface StudentDao {

	int userNameSearch(User user);

	int userPasswordSearch(User user);

	List<SubjectTest> getUserIfTest(int userId);

	List<ZuJuan> getTestRInfo(int testId);

	void setTestInfo(Score score);

	List<Score> getSumScore(Score score);

	void studentTestSave(Score score);

	List<Test> getTest(int userId);

	int setScore(Score score);

	List<TestInfo> setTestByTeseId(Score score);

	List<TestInfo> setTestByTeseId1(Score score);

	
}
