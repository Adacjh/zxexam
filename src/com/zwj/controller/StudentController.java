package com.zwj.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwj.model.Score;
import com.zwj.model.SubjectTest;
import com.zwj.model.Test;
import com.zwj.model.TestInfo;
import com.zwj.model.User;
import com.zwj.model.ZuJuan;
import com.zwj.service.StudentService;
import com.zwj.service.UserService;
import com.zwj.service.ZujuanService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private ZujuanService zujuanService;
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ResourceBundleMessageSource messageSource;// 注入国际化

	@ResponseBody
	@RequestMapping(value = "/studentLogin.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String studentLogin(User user, HttpServletRequest request) {
		String errorMessage = "登录成功";
		if (user.getUserAccountNumber() == null
				|| "".equals(user.getUserAccountNumber())) {
			errorMessage = messageSource.getMessage("USER_NAME_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}
		int count = studentService.userNameSearch(user);
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
		int count1 = studentService.userPasswordSearch(user);
		if (count1 == 0) {
			errorMessage = messageSource.getMessage("USER_PASSWORD_ERROR",
					null, Locale.getDefault());
			return errorMessage;
		}
		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getUserName());
		// session.getAttribute("userName");
		errorMessage = String.valueOf(user.getUserRole());
		return errorMessage;

	}

	/**
	 * 
	 * 
	 * @Title: getTestInfo
	 * @Description: TODO(获取考生还没参加考试的试卷信息)
	 * @param @param request
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getTestInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getTestInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		int userId = userList.get(0).getUserId();
		List<SubjectTest> testNameInfo = studentService.getUserIfTest(userId);
		String testInfo = JSONArray.fromObject(testNameInfo).toString();
		return testInfo;
	}

	/**
	 * 选择试卷开始考试
	 * 
	 * @Title: actionTest
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @param testId
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/actionTest.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String actionTest(HttpServletRequest request, String questionBh, int type) {
		ZuJuan zuJuan=new ZuJuan();
		zuJuan.setQuestionBh(questionBh);
		List<ZuJuan> testList = new ArrayList<ZuJuan>();
		if (type == 1) {
			testList = zujuanService.subTestInfo(zuJuan);
			
		} else if (type == 2) {
			testList = zujuanService.subTestInfo1(zuJuan);
		}
		String testInfo = JSONArray.fromObject(testList).toString();
		return testInfo;
	}
	/**
	 * 
	 * @Title: testChoiceSave
	 * @Description: TODO(保存学生单选题答案)
	 * @param @param answer
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/testChoiceSave.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String testChoiceSave(String answer,String bh,HttpServletRequest request){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		int userId = userList.get(0).getUserId();		
		String number = studentService.setTestInfo(answer,userId,bh);
        	
		return number;
		
	}
	/**
	 * 
	 * @Title: testCheckSave
	 * @Description: TODO(保存学生多选题答案)
	 * @param @param score
	 * @param @param request
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/testCheckSave.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String testCheckSave(Score score,HttpServletRequest request){
		String number="";
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		score.setUserId(userList.get(0).getUserId());
		if(score.getNumber().equals("undefined")||score.getNumber()==null){
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
				    number = dateFormat.format( now );
				    score.setNumber(number);
		}else{
		}
		int count=studentService.testCheckSave(score);
		return number;
		
	}
/**
 * 
 * @Title: studentTestSave
 * @Description: TODO(考试成功，显示成绩信息)
 * @param @param score
 * @param @param request
 * @param @return
 * @return String  返回类型
 * @throws
 */
	@ResponseBody
	@RequestMapping(value = "/studentTestSave.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String studentTestSave(Score score,HttpServletRequest request){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		score.setUserId(userList.get(0).getUserId());
		int sumScore=studentService.getSumScore(score);
		score.setScore(sumScore);
		int count =studentService.studentTestSave(score);
		String getScore="9001";
		if(count==1){
			getScore=String.valueOf(sumScore);
		}
		
		return getScore;
	
	}
	/**
	 * 获取已经考试的信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTest.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getTest(HttpServletRequest request){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		int userId=userList.get(0).getUserId();
		List<Test> testList= studentService.getTest(userId);
		String testInfo = JSONArray.fromObject(testList).toString();
		return testInfo;
		
	}
	/**
	 * 
	 * @Title: setTestByTeseId
	 * @Description: TODO(通过试卷ID获取试卷单选题和多选题信息)
	 * @param @param request
	 * @param @param testId
	 * @param @param type
	 * @param @param id
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/setTestByTeseId.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String setTestByTeseId(HttpServletRequest request,String testId,int type,String id){
		Score score=new Score();
		if(id.equals("kong")){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<User> userList = userService.searchUserInfo(userName);
		score.setUserId(userList.get(0).getUserId());
		}else{
			score.setUserId(Integer.parseInt(id));
		}
		score.setTestId(testId);
		List<TestInfo> testInfoList=new ArrayList<TestInfo>();
		if(type==1){
		 testInfoList=studentService.setTestByTeseId(score);//获取单选题
		}else{
		testInfoList=studentService.setTestByTeseId1(score);//获取多选
		}
		String testInfo = JSONArray.fromObject(testInfoList).toString();
		return testInfo;
		
	}
	/**
	 * 
	 * @Title: getTestByUserId
	 * @Description: TODO(获取该学生已经考试的试卷信息)
	 * @param @param request
	 * @param @param userId
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getTestByUserId.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getTestByUserId(HttpServletRequest request,int userId){
		List<Test> testList= studentService.getTest(userId);
		String testInfo = JSONArray.fromObject(testList).toString();
		return testInfo;
	}
}
