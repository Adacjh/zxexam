package com.zwj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwj.dao.UserDao;
import com.zwj.model.Page;
import com.zwj.model.User;
import com.zwj.service.UserService;
import com.zwj.util.Tool;
@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int userNameSearch(User user) {
		// TODO Auto-generated method stub
		return userDao.userNameSearch(user);
	}

	@Override
	public int userPasswordSearch(User user) {
		// TODO Auto-generated method stub
		return userDao.userPasswordSearch(user);
	}

	@Override
	public List<User> getStudentInfo(Page page) {
		// TODO Auto-generated method stub
		return userDao.getStudentInfo(page);
	}

	@Override
	public List<User> getTeacherInfo(Page page) {
		// TODO Auto-generated method stub
		return userDao.getTeacherInfo(page);
	}

	@Override
	public int delStudentInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.delStudentInfo(user);
	}

	@Override
	public int getPageInfo() {
		// TODO Auto-generated method stub
		return userDao.getPageInfo();
	}

	@Override
	public int delTeacherInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.delTeacherInfo(user);
	}

	@Override
	public int getPageInfo1() {
		// TODO Auto-generated method stub
		return userDao.getPageInfo1();
	}

	@Override
	public int stuRegist(User user) {
		// TODO Auto-generated method stub
		return userDao.stuRegist(user);
	}

	@Override
	public List<User> searchUserInfo(String userName) {
		// TODO Auto-generated method stub
		return userDao.searchUserInfo(userName);
	}

	@Override
	public String searchUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.searchUserById(userId);
	}

	@Override
	public int ifExist(User user) {
		// TODO Auto-generated method stub
		return userDao.ifExist(user);
	}

	@Override
	public void teacherAdd(User user) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    String number = dateFormat.format( now );
	    int ran=Tool.getRandomString(4);
	    number=number+ran+"";
	    user.setUserPassword(number);
	    user.setUserAccountNumber(number);
	    userDao.teacherAdd(user);
	}

	@Override
	public int yZpassWord(String passWord,int userId) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserPassword(passWord);
		user.setUserId(userId);
		
		return userDao.yZpassWord(user);
	}

	@Override
	public void updatePassWord(User user) {
		userDao.updatePassWord(user);
		
	}

	@Override
	public int ifExistUser(User user) {
		// TODO Auto-generated method stub
		return userDao.ifExistUser(user);
	}

	@Override
	public int ifExistPhone(User user) {
		// TODO Auto-generated method stub
		return userDao.ifExistPhone(user);
	}

	@Override
	public int ifPiPei(User user) {
		// TODO Auto-generated method stub
		return userDao.ifPiPei(user);
	}

	@Override
	public void userPassWordUpde(User user) {
		// TODO Auto-generated method stub
		userDao.userPassWordUpde(user);
	}

	
}
