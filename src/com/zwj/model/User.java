package com.zwj.model;

public class User {
   private int userId;//用户id
   private String userAccountNumber;//用户账号
   private String userName;//真实姓名
   private String userPassword;//用户密码
   private String userPasswordAgain;//确认密码
   private int userSex;//用户性别
   private int userRole;//用户权限
   private String userPhone;//手机号码
   private String userDate;//用户创建时间
   private int userState;//用户状态
   private int roleId;//权限id
   private String roleName;//权限名称
   private String userValue;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserAccountNumber() {
	return userAccountNumber;
}
public void setUserAccountNumber(String userAccountNumber) {
	this.userAccountNumber = userAccountNumber;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getUserPasswordAgain() {
	return userPasswordAgain;
}
public void setUserPasswordAgain(String userPasswordAgain) {
	this.userPasswordAgain = userPasswordAgain;
}
public int getUserSex() {
	return userSex;
}
public void setUserSex(int userSex) {
	this.userSex = userSex;
}
public int getUserRole() {
	return userRole;
}
public void setUserRole(int userRole) {
	this.userRole = userRole;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public String getUserDate() {
	return userDate;
}
public void setUserDate(String userDate) {
	this.userDate = userDate;
}
public int getUserState() {
	return userState;
}
public void setUserState(int userState) {
	this.userState = userState;
}
public int getRoleId() {
	return roleId;
}
public void setRoleId(int roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public String getUserValue() {
	return userValue;
}
public void setUserValue(String userValue) {
	this.userValue = userValue;
}

   
}
