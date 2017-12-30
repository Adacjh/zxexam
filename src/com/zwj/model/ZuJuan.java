package com.zwj.model;

public class ZuJuan {
	private int zujuanId;//试卷id
	private String zujuanName;//试卷名称
	private String zujuanType;//试题的类型
	private String zujuanNumber;//试题数量
	private String zujuanDifficulty;//试卷难度
	private String zujuanScore;//试卷每题分值
	private String questionBh;//题目编号
	private int questionId;//题目ID
	private int testTime;
	private int subName;
	public int getZujuanId() {
		return zujuanId;
	}
	public void setZujuanId(int zujuanId) {
		this.zujuanId = zujuanId;
	}
	public String getZujuanName() {
		return zujuanName;
	}
	public void setZujuanName(String zujuanName) {
		this.zujuanName = zujuanName;
	}
	public String getZujuanType() {
		return zujuanType;
	}
	public void setZujuanType(String zujuanType) {
		this.zujuanType = zujuanType;
	}
	public String getZujuanNumber() {
		return zujuanNumber;
	}
	public void setZujuanNumber(String zujuanNumber) {
		this.zujuanNumber = zujuanNumber;
	}
	public String getZujuanDifficulty() {
		return zujuanDifficulty;
	}
	public void setZujuanDifficulty(String zujuanDifficulty) {
		this.zujuanDifficulty = zujuanDifficulty;
	}
	public String getZujuanScore() {
		return zujuanScore;
	}
	public void setZujuanScore(String zujuanScore) {
		this.zujuanScore = zujuanScore;
	}
	public String getQuestionBh() {
		return questionBh;
	}
	public void setQuestionBh(String questionBh) {
		this.questionBh = questionBh;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public int getSubName() {
		return subName;
	}
	public void setSubName(int subName) {
		this.subName = subName;
	}
	

}
