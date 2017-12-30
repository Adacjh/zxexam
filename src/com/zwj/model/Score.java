package com.zwj.model;

public class Score {
private int id;
private String testId;
private String testName;
private int userId;
private String number;
private String answer;
private String myAnswer;
private int score;
private int sumScore;
private int type;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTestId() {
	return testId;
}
public void setTestId(String testId) {
	this.testId = testId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

public String getTestName() {
	return testName;
}
public void setTestName(String testName) {
	this.testName = testName;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getMyAnswer() {
	return myAnswer;
}
public void setMyAnswer(String myAnswer) {
	this.myAnswer = myAnswer;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}

public int getSumScore() {
	return sumScore;
}
public void setSumScore(int sumScore) {
	this.sumScore = sumScore;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}


}
