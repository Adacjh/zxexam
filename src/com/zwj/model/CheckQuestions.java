package com.zwj.model;

public class CheckQuestions {
   private int checkId;//单选题题号
   private String checkContent;//题目内容
   private String checkAnswerA;//选项A
   private String checkAnswerB;//选项B
   private String checkAnswerC;//选项C
   private String checkAnswerD;//选项D
   private String checkAnswer;//正确的答案
   private int checkDifficulty;//题目难度
   private String checkDate;//正确的答案
   private int checkState;//题目状态
   private int difficultyId;//难度ID
   private String difficultyType;//难度类型
   private String checkBh;//题目编号
   private int score;
   private String checkSubName;//科目名
   private int testTime;
   private String subjectName;

public String getCheckSubName() {
	return checkSubName;
}
public void setCheckSubName(String checkSubName) {
	this.checkSubName = checkSubName;
}
public int getCheckId() {
	return checkId;
}
public void setCheckId(int checkId) {
	this.checkId = checkId;
}
public String getCheckContent() {
	return checkContent;
}
public void setCheckContent(String checkContent) {
	this.checkContent = checkContent;
}
public String getCheckAnswerA() {
	return checkAnswerA;
}
public void setCheckAnswerA(String checkAnswerA) {
	this.checkAnswerA = checkAnswerA;
}
public String getCheckAnswerB() {
	return checkAnswerB;
}
public void setCheckAnswerB(String checkAnswerB) {
	this.checkAnswerB = checkAnswerB;
}
public String getCheckAnswerC() {
	return checkAnswerC;
}
public void setCheckAnswerC(String checkAnswerC) {
	this.checkAnswerC = checkAnswerC;
}
public String getCheckAnswerD() {
	return checkAnswerD;
}
public void setCheckAnswerD(String checkAnswerD) {
	this.checkAnswerD = checkAnswerD;
}
public String getCheckAnswer() {
	return checkAnswer;
}
public void setCheckAnswer(String checkAnswer) {
	this.checkAnswer = checkAnswer;
}
public int getCheckDifficulty() {
	return checkDifficulty;
}
public void setCheckDifficulty(int checkDifficulty) {
	this.checkDifficulty = checkDifficulty;
}
public String getCheckDate() {
	return checkDate;
}
public void setCheckDate(String checkDate) {
	this.checkDate = checkDate;
}
public int getCheckState() {
	return checkState;
}
public void setCheckState(int checkState) {
	this.checkState = checkState;
}
public int getDifficultyId() {
	return difficultyId;
}
public void setDifficultyId(int difficultyId) {
	this.difficultyId = difficultyId;
}
public String getDifficultyType() {
	return difficultyType;
}
public void setDifficultyType(String difficultyType) {
	this.difficultyType = difficultyType;
}
public String getCheckBh() {
	return checkBh;
}
public void setCheckBh(String checkBh) {
	this.checkBh = checkBh;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getTestTime() {
	return testTime;
}
public void setTestTime(int testTime) {
	this.testTime = testTime;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

}
