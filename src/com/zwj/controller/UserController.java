package com.zwj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwj.model.Page;
import com.zwj.model.User;
import com.zwj.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;// 注入国际化



	
	
	@ResponseBody
	@RequestMapping(value = "/userLogin.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String userLogin(User user, HttpServletRequest request) {
		String errorMessage = "登录成功";
		if (user.getUserAccountNumber() == null
				|| "".equals(user.getUserAccountNumber())) {
			errorMessage = messageSource.getMessage("USER_NAME_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		int count = userService.userNameSearch(user);
		if (count == 0) {
			errorMessage = messageSource.getMessage("USER_NAME_NOTEXIST", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPassword() == null || "".equals(user.getUserPassword())) {
			errorMessage = messageSource.getMessage("USER_PASSWORD_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		int count1 = userService.userPasswordSearch(user);
		if (count1 == 0) {
			errorMessage = messageSource.getMessage("USER_PASSWORD_ERROR",
					null, Locale.getDefault());
			return errorMessage;
		}
		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getUserAccountNumber());//设置session
		// session.getAttribute("userName");
		errorMessage = String.valueOf(user.getUserRole());
		return errorMessage;

	}

	/**
	 * 
	 * @Title: getStudentInfo
	 * @Description: TODO(学生管理)
	 * @param @param page
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getStudentInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getStudentInfo(Page page) {
		if (page.getNumber() == 1) {
			page.setBegin(0);
			page.setEnd(5);
		} else {
			page.setBegin((page.getNumber() - 1) * 5);
			page.setEnd(5);
		}
		List<User> studentList = userService.getStudentInfo(page);
		for (int i = 0; i < studentList.size(); i++) {
			studentList.get(i).setUserDate(
					studentList.get(i).getUserDate().substring(0, 10));
		}
		String UserInfo = JSONArray.fromObject(studentList).toString();

		return UserInfo;
	}

	/**
	 * 
	 * @Title: getTeacherInfo
	 * @Description: TODO(教师管理)
	 * @param @param page
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getTeacherInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getTeacherInfo(Page page) {
		if (page.getNumber() == 1) {
			page.setBegin(0);
			page.setEnd(5);
		} else {
			page.setBegin((page.getNumber() - 1) * 5);
			page.setEnd(5);
		}
		List<User> teacherList = userService.getTeacherInfo(page);
		for (int i = 0; i < teacherList.size(); i++) {
			teacherList.get(i).setUserDate(
					teacherList.get(i).getUserDate().substring(0, 10));
		}
		String UserInfo = JSONArray.fromObject(teacherList).toString();

		return UserInfo;
	}

	/**
	 * 
	 * @Title: delStudentInfo
	 * @Description: TODO(删除学生（更改学生状态）)
	 * @param @param user
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delStudentInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delStudentInfo(int userId, int pageId) {
		User user = new User();
		Page page = new Page();
		user.setUserId(userId);
		List<User> studentList = new ArrayList<User>();
		int count = userService.delStudentInfo(user);
		String errorMessage = "删除成功";
		if (count == 0) {
			errorMessage = messageSource.getMessage("USER_NAME_DEL", null,
					Locale.getDefault());
			return errorMessage;
		}
		page.setNumber(pageId);
		if (page.getNumber() == 1) {
			page.setBegin(0);
			page.setEnd(5);
		} else {
			page.setBegin((page.getNumber() - 1) * 5);
			page.setEnd(5);
		}
		studentList = userService.getStudentInfo(page);
		int pagaNumber = 0;
		if (studentList.size() == 0) {
			pagaNumber = page.getNumber() - 1;
			if (pagaNumber == 0) {
				pagaNumber = 1;
			}
			if (pagaNumber == 1) {
				page.setBegin(0);
				page.setEnd(5);
			} else {
				page.setBegin((pagaNumber - 1) * 5);
				page.setEnd(5);
			}
			studentList = userService.getStudentInfo(page);
		} else {

		}

		String studentInfo = JSONArray.fromObject(studentList).toString();
		return studentInfo;
	}

	/**
	 * 
	 * @Title: delTeacherInfo
	 * @Description: TODO(删除教师（更改教师状态）)
	 * @param @param user
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delTeacherInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delTeacherInfo(int userId, int pageId) {
		User user = new User();
		Page page = new Page();
		user.setUserId(userId);
		List<User> teacherList = new ArrayList<User>();
		int count = userService.delTeacherInfo(user);
		String errorMessage = "删除成功";
		if (count == 0) {
			errorMessage = messageSource.getMessage("USER_NAME_DEL", null,
					Locale.getDefault());
			return errorMessage;
		}
		page.setNumber(pageId);
		if (page.getNumber() == 1) {
			page.setBegin(0);
			page.setEnd(5);
		} else {
			page.setBegin((page.getNumber() - 1) * 5);
			page.setEnd(5);
		}
		teacherList = userService.getTeacherInfo(page);
		int pagaNumber = 0;
		if (teacherList.size() == 0) {
			pagaNumber = page.getNumber() - 1;
			if (pagaNumber == 0) {
				pagaNumber = 1;
			}
			if (pagaNumber == 1) {
				page.setBegin(0);
				page.setEnd(5);
			} else {
				page.setBegin((pagaNumber - 1) * 5);
				page.setEnd(5);
			}
			teacherList = userService.getTeacherInfo(page);
		} else {

		}
		String teacherInfo = JSONArray.fromObject(teacherList).toString();
		return teacherInfo;

	}

	/**
	 * 
	 * @Title: getPageInfo
	 * @Description: TODO(学生分页)
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getPageInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getPageInfo() {
		Page page = new Page();
		int pageSize = userService.getPageInfo();
		page.setPageSum(pageSize);
		if (pageSize <= 5) {
			int page1 = 1;
			page.setPageSize(page1);

		} else if (pageSize % 5 != 0) {
			int page1 = (pageSize / 5) + 1;
			page.setPageSize(page1);
		} else {
			int page1 = pageSize / 5;
			page.setPageSize(page1);
		}
		String pageInfo = JSONArray.fromObject(page).toString();
		return pageInfo;

	}

	/**
	 * 
	 * @Title: getPageInfo
	 * @Description: TODO(教师分页)
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getPageInfo1.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getPageInfo1() {
		Page page = new Page();
		int pageSize = userService.getPageInfo1();
		page.setPageSum(pageSize);
		if (pageSize <= 5) {
			int page1 = 1;
			page.setPageSize(page1);

		} else if (pageSize % 5 != 0) {
			int page1 = (pageSize / 5) + 1;
			page.setPageSize(page1);
		} else {
			int page1 = pageSize / 5;
			page.setPageSize(page1);
		}
		String pageInfo = JSONArray.fromObject(page).toString();
		return pageInfo;

	}

	@ResponseBody
	@RequestMapping(value = "/stuRegist.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String stuRegist(User user) {
		String errorMessage = "注册成功";
		if (user.getUserAccountNumber() == null
				|| "".equals(user.getUserAccountNumber())) {
			errorMessage = messageSource.getMessage("USER_NUMBER_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		int count = userService.userNameSearch(user);
		if (count > 0) {
			errorMessage = messageSource.getMessage("USER_NAME_EXIST", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserName() == null || "".equals(user.getUserName())) {
			errorMessage = messageSource.getMessage("USER_ZHENGSHINAME_NULL",
					null, Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPassword() == null || "".equals(user.getUserPassword())) {
			errorMessage = messageSource.getMessage("USER_MIMA_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPasswordAgain() == null
				|| "".equals(user.getUserPasswordAgain())) {
			errorMessage = messageSource.getMessage("USER_MIMAAGIN_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (!user.getUserPasswordAgain().equals(user.getUserPassword())) {
			errorMessage = messageSource.getMessage("PASSWORD_NO_SAME", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPhone() == null || "".equals(user.getUserPhone())) {
			errorMessage = messageSource.getMessage("USER_PHONE_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPhone().length() != 11) {
			errorMessage = messageSource.getMessage("USER_PHONE_WEISHU", null,
					Locale.getDefault());
			return errorMessage;
		}
		String phone = user.getUserPhone();
		String regEx = "((17[0-9])(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(phone);
		boolean rs = matcher.matches();
		if (!rs) {
			errorMessage = messageSource.getMessage("PHONE_ERROR", null,
					Locale.getDefault());// 电话号码格式验证
			return errorMessage;
		} else {
			int ifExist = userService.ifExist(user);
			if (ifExist > 0) {
				errorMessage = messageSource.getMessage("PHONE_EXIST", null,
						Locale.getDefault());// 电话号码格式验证
				return errorMessage;
			}
		}
		int count1 = userService.stuRegist(user);
		if (count1 == 0) {
			errorMessage = messageSource.getMessage("STUDENT_REGIST_FALSE",
					null, Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}

	@ResponseBody
	@RequestMapping(value = "/searchUserInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String searchUserInfo(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		String userInfo = JSONArray.fromObject(userList).toString();
		return userInfo;

	}

	@ResponseBody
	@RequestMapping(value = "/searchUserById.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String searchUserById(int userId, HttpServletRequest request) {
		String name = userService.searchUserById(userId);
		return name;

	}

	@ResponseBody
	@RequestMapping(value = "/teacherAdd.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String teacherAdd(User user) {
		String errorMessage = "1";
		if (user.getUserName() == null || "".equals(user.getUserName())) {
			errorMessage = messageSource.getMessage("USER_ZHENGSHINAME_NULL",
					null, Locale.getDefault());
			return errorMessage;
		}
		String phone = user.getUserPhone();
		String regEx = "((17[0-9])(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(phone);
		boolean rs = matcher.matches();
		if (!rs) {
			errorMessage = messageSource.getMessage("PHONE_ERROR", null,
					Locale.getDefault());// 电话号码格式验证
			return errorMessage;
		} else {
			int ifExist = userService.ifExist(user);
			if (ifExist > 0) {
				errorMessage = messageSource.getMessage("PHONE_EXIST", null,
						Locale.getDefault());// 电话号码格式验证
				return errorMessage;
			}
		}
		try {
			userService.teacherAdd(user);
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = messageSource.getMessage("STUDENT_REGIST_FALSE",
					null, Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}

	@ResponseBody
	@RequestMapping(value = "/yZpassWord.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String yZpassWord(String passWord, HttpServletRequest request) {
		String errorMessage = "1";
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		int userId = userList.get(0).getUserId();
		int ifExist = userService.yZpassWord(passWord, userId);
		if (ifExist == 0) {
			errorMessage = messageSource.getMessage("OLD_PASSWORD_ERROR", null,
					Locale.getDefault());// 电话号码格式验证
			return errorMessage;
		}
		return errorMessage;

	}

	@ResponseBody
	@RequestMapping(value = "/updatePassWord.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updatePassWord(User user, HttpServletRequest request) {

		String errorMessage = "1";
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		user.setUserId(userList.get(0).getUserId());
		if (user.getUserPassword().equals("")
				|| user.getUserPasswordAgain() == null) {
			errorMessage = messageSource.getMessage("USER_PASSWORD_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPasswordAgain().equals("")
				|| user.getUserPasswordAgain() == null) {
			errorMessage = messageSource.getMessage("USER_REPASSWORD_NULL",
					null, Locale.getDefault());
			return errorMessage;
		}
		if (!user.getUserPassword().equals(user.getUserPasswordAgain())) {
			errorMessage = messageSource.getMessage("PASSWORDS_ERROR", null,
					Locale.getDefault());
			return errorMessage;
		}
		try {
			userService.updatePassWord(user);
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "9001";
		}
		return errorMessage;

	}

	@ResponseBody
	@RequestMapping(value = "/userInfoYz.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String userInfoYz(User user, HttpServletRequest request) {
		String errorMessage = "1";

		if (!"".equals(user.getUserAccountNumber())) {
			int ifExist1 = userService.ifExistUser(user);
			if (ifExist1 == 0) {
				errorMessage = messageSource.getMessage("USER_NAME_NOTEXIST",
						null, Locale.getDefault());
				return errorMessage;
			}
		}
		String phone = user.getUserPhone();
		if (phone.equals("")) {
		} else {
			String regEx = "((17[0-9])(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(phone);
			boolean rs = matcher.matches();
			if (!rs) {
				errorMessage = messageSource.getMessage("PHONE_ERROR", null,
						Locale.getDefault());// 电话号码格式验证
				return errorMessage;
			} else {
				int ifExist2 = userService.ifExistPhone(user);
				if (ifExist2 == 0) {
					errorMessage = messageSource.getMessage("PHONE_EXIST_NULL",
							null, Locale.getDefault());
					return errorMessage;
				}
			}
		}
		if (!user.getUserAccountNumber().equals("")&& !user.getUserPhone().equals("")) {
			int ifExist3 = userService.ifPiPei(user);
			if (ifExist3 == 0) {
				errorMessage = messageSource.getMessage("NO_PI_PEI", null,
						Locale.getDefault());
			}
		}
		return errorMessage;

	}

	/**
	 * 
	 * @Title: userPassWordUpde
	 * @Description: TODO(重置密码)
	 * @param @param user
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/userPassWordUpde.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String userPassWordUpde(User user) {
		String errorMessage = "1";
		if (user.getUserAccountNumber() == null
				|| "".equals(user.getUserAccountNumber())) {
			errorMessage = messageSource.getMessage("USER_NUMBER_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPhone() == null || "".equals(user.getUserPhone())) {
			errorMessage = messageSource.getMessage("USER_PHONE_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (!"".equals(user.getUserAccountNumber())) {
			int ifExist1 = userService.ifExistUser(user);
			if (ifExist1 == 0) {
				errorMessage = messageSource.getMessage("USER_NAME_NOTEXIST",
						null, Locale.getDefault());
				return errorMessage;
			}
		}
		String phone = user.getUserPhone();
		if (phone.equals("")) {
		} else {
			String regEx = "((17[0-9])(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(phone);
			boolean rs = matcher.matches();
			if (!rs) {
				errorMessage = messageSource.getMessage("PHONE_ERROR", null,
						Locale.getDefault());// 电话号码格式验证
				return errorMessage;
			} else {
				int ifExist2 = userService.ifExistPhone(user);
				if (ifExist2 == 0) {
					errorMessage = messageSource.getMessage("PHONE_EXIST_NULL",
							null, Locale.getDefault());
					return errorMessage;
				}
			}
		}
		if (!user.getUserAccountNumber().equals("")&& !user.getUserPhone().equals("")) {
			int ifExist3 = userService.ifPiPei(user);
			if (ifExist3 == 0) {
				errorMessage = messageSource.getMessage("NO_PI_PEI", null,
						Locale.getDefault());
			}
		}
		if (user.getUserPassword().equals("") || user.getUserPassword() == null) {
			errorMessage = messageSource.getMessage("USER_PASSWORD_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (user.getUserPasswordAgain().equals("")
				|| user.getUserPasswordAgain() == null) {
			errorMessage = messageSource.getMessage("USER_MIMAAGIN_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		if (!user.getUserPassword().equals(user.getUserPasswordAgain())) {
			errorMessage = messageSource.getMessage("PASSWORDS_ERROR", null,
					Locale.getDefault());
			return errorMessage;
		}
		
		try {
			userService.userPassWordUpde(user);
		} catch (Exception e) {
			errorMessage = "9001";
		}
		return errorMessage;

	}
}
