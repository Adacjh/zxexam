package com.zwj.dao;

import java.util.List;

import com.zwj.model.Page;
import com.zwj.model.User;

public interface UserDao {

	int userNameSearch(User user);

	int userPasswordSearch(User user);

	List<User> getStudentInfo(Page page);

	List<User> getTeacherInfo(Page page);

	int delStudentInfo(User user);

	int getPageInfo();

	int delTeacherInfo(User user);

	int getPageInfo1();

	int stuRegist(User user);

	List<User> searchUserInfo(String userName);

	String searchUserById(int userId);

	int ifExist(User user);

	void teacherAdd(User user);

	int yZpassWord(String passWord, int userId);

	int yZpassWord(User user);

	void updatePassWord(User user);

	int ifExistPhone(User user);

	int ifPiPei(User user);

	int ifExistUser(User user);

	void userPassWordUpde(User user);

}
