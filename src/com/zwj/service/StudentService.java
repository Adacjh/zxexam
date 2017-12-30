package com.zwj.service;

import java.util.List;

import com.zwj.model.Score;
import com.zwj.model.SubjectTest;
import com.zwj.model.Test;
import com.zwj.model.TestInfo;
import com.zwj.model.User;
import com.zwj.model.ZuJuan;



public interface StudentService {

	int userNameSearch(User user);

	int userPasswordSearch(User user);

	List<SubjectTest> getUserIfTest(int userId);

	List<ZuJuan> getTestRInfo(int testId);

	String setTestInfo(String answer, int userId,String bh);

	int testCheckSave(Score score);

	int getSumScore(Score score);

	int studentTestSave(Score score);
/**
 * 获取已经考完试的试卷
 * @param userId
 * @return
 */
	List<Test> getTest(int userId);
/**
 * 获取已经考完试的试卷详细考试信息
 * @param score
 * @return
 */
List<TestInfo> setTestByTeseId(Score score);
/**
 * 获取多选系你先
 * @param score
 * @return
 */
List<TestInfo> setTestByTeseId1(Score score);



	

}
