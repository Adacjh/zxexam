package com.zwj.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwj.dao.StudentDao;
import com.zwj.model.Score;
import com.zwj.model.SubjectTest;
import com.zwj.model.Test;
import com.zwj.model.TestInfo;
import com.zwj.model.User;
import com.zwj.model.ZuJuan;
import com.zwj.service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public int userNameSearch(User user) {
		// TODO Auto-generated method stub
		return studentDao.userNameSearch(user);
	}

	@Override
	public int userPasswordSearch(User user) {
		// TODO Auto-generated method stub
		return studentDao.userPasswordSearch(user);
	}

	@Override
	public List<SubjectTest> getUserIfTest(int userId) {
		// TODO Auto-generated method stub
		return studentDao.getUserIfTest(userId);
	}

	@Override
	public List<ZuJuan> getTestRInfo(int testId) {
		// TODO Auto-generated method stub
		return studentDao.getTestRInfo(testId);
	}

	public String setTestInfo(String answer, int userId,String bh) {
		String number = "";
		try {
			if(bh.equals("undefined")||bh==null){
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			number = dateFormat.format(now);
			}else{
				number=bh;
			}
			Score score = new Score();
			String[] testInfo = answer.split(",");
			score.setMyAnswer(testInfo[2]);
			score.setTestId(testInfo[0]);
			score.setAnswer(testInfo[3]);
			score.setScore(Integer.valueOf(testInfo[1]));
			score.setUserId(userId);
			score.setType(1);
			score.setNumber(number);
			studentDao.setTestInfo(score);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public int testCheckSave(Score score) {
		int count = 1;
		try {
			if (!score.getMyAnswer().equals("未答题")) {
				String[] answer = score.getMyAnswer().split(",");
				int len = answer.length;
				score.setMyAnswer(score.getMyAnswer().substring(0, len * 2 - 1));
			}
			score.setType(2);
			studentDao.setTestInfo(score);
		} catch (Exception e) {
			e.printStackTrace();
			count = 0;
		}
		return count;
	}

	@Override
	public int getSumScore(Score score) {
		int sum=0;
		List<Score> sumScore=new ArrayList<Score>();
		sumScore=studentDao.getSumScore(score);
		for (int i = 0; i < sumScore.size(); i++) {
			sum=sumScore.get(i).getScore()+sum;
		}
		return sum;
	}

	@Override
	public int studentTestSave(Score score) {
		int count = 0;
		try {
			score.setSumScore(studentDao.setScore(score));
			studentDao.studentTestSave(score);
			count = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Test> getTest(int userId) {
		
		return studentDao.getTest(userId);
	}

	@Override
	public List<TestInfo> setTestByTeseId(Score score) {
		// TODO Auto-generated method stub
		return studentDao.setTestByTeseId(score);
	}

	@Override
	public List<TestInfo> setTestByTeseId1(Score score) {
		// TODO Auto-generated method stub
		return studentDao.setTestByTeseId1(score);
	}
}
