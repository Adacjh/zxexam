package com.zwj.model;

public class RadioQuestions {
   private int radioId;//单选题题号
   private String radioContent;//题目内容
   private String radioAnswerA;//选项A
   private String radioAnswerB;//选项B
   private String radioAnswerC;//选项C
   private String radioAnswerD;//选项D
   private String radioAnswer;//正确的答案
   private int radioDifficulty;//题目难度
   private String radioDate;//正确的答案
   private int radioState;//题目状态
   private int difficultyId;//难度ID
   private String difficultyType;//难度类型
   private String radioBh;//题目编号
   private int score;
   private String radioSubName;
   private int testTime;
   private String subjectName;
   
public String getRadioSubName() {
	return radioSubName;
}
public void setRadioSubName(String radioSubName) {
	this.radioSubName = radioSubName;
}
public int getRadioId() {
	return radioId;
}
public void setRadioId(int radioId) {
	this.radioId = radioId;
}
public String getRadioContent() {
	return radioContent;
}
public void setRadioContent(String radioContent) {
	this.radioContent = radioContent;
}
public String getRadioAnswerA() {
	return radioAnswerA;
}
public void setRadioAnswerA(String radioAnswerA) {
	this.radioAnswerA = radioAnswerA;
}
public String getRadioAnswerB() {
	return radioAnswerB;
}
public void setRadioAnswerB(String radioAnswerB) {
	this.radioAnswerB = radioAnswerB;
}
public String getRadioAnswerC() {
	return radioAnswerC;
}
public void setRadioAnswerC(String radioAnswerC) {
	this.radioAnswerC = radioAnswerC;
}
public String getRadioAnswerD() {
	return radioAnswerD;
}
public void setRadioAnswerD(String radioAnswerD) {
	this.radioAnswerD = radioAnswerD;
}
public String getRadioAnswer() {
	return radioAnswer;
}
public void setRadioAnswer(String radioAnswer) {
	this.radioAnswer = radioAnswer;
}
public int getRadioDifficulty() {
	return radioDifficulty;
}
public void setRadioDifficulty(int radioDifficulty) {
	this.radioDifficulty = radioDifficulty;
}
public String getRadioDate() {
	return radioDate;
}
public void setRadioDate(String radioDate) {
	this.radioDate = radioDate;
}
public int getRadioState() {
	return radioState;
}
public void setRadioState(int radioState) {
	this.radioState = radioState;
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
public String getRadioBh() {
	return radioBh;
}
public void setRadioBh(String radioBh) {
	this.radioBh = radioBh;
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
