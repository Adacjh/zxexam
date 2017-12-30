package com.zwj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwj.model.CheckQuestions;
import com.zwj.model.RadioQuestions;
import com.zwj.model.Subject;
import com.zwj.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private ResourceBundleMessageSource messageSource;//注入国际
	/**
	 * 
	 * @Title: addRaQuestion
	 * @Description: TODO(增加单选题)
	 * @param @param radioQuestions
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addRaQuestion.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addRaQuestion(RadioQuestions radioQuestions){
		int count=questionService.addRaQuestion(radioQuestions);
		String errorMessage = "添加成功";
		if(count==0){
			errorMessage = messageSource.getMessage("ADD_QUESTION_FALSE", null,
					Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}
	/**
	 * 
	 * @Title: getRaQuestions
	 * @Description: TODO(查看单选题)
	 * @param @param radioQuestions
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getRaQuestions.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String getRaQuestions(RadioQuestions radioQuestions,String subId){
		int id=Integer.valueOf(subId);
		List<RadioQuestions> radioList=questionService.getRaQuestions(id);
	    String UserInfo = JSONArray.fromObject(radioList).toString();

		return UserInfo;
	}
	/**
	 * 
	 * @Title: addChQuestion
	 * @Description: TODO(添加多选题)
	 * @param @param checkQuestions
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addChQuestion.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addChQuestion(CheckQuestions checkQuestions){
		//checkQuestions.setCheckAnswer(checkQuestions.getCheckAnswerA()+checkQuestions.getCheckAnswerB()+checkQuestions.getCheckAnswerC()+checkQuestions.getCheckAnswerD());
		int count=questionService.addChQuestion(checkQuestions);
		String errorMessage = "添加成功";
		if(count==0){
			errorMessage = messageSource.getMessage("ADD_QUESTION_FALSE", null,
					Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}
	/**
	 * 
	 * @Title: getChQuestions
	 * @Description: TODO(查看多选题)
	 * @param @param checkQuestions
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getChQuestions.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String getChQuestions(CheckQuestions checkQuestions,String subId){
		int id=Integer.valueOf(subId);
		List<CheckQuestions> radioList=questionService.getChQuestions(id);
		
	    String UserInfo = JSONArray.fromObject(radioList).toString();

		return UserInfo;
	}
	@ResponseBody
	@RequestMapping(value = "/getSubName.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String getSubName(String subId){
		String name=questionService.getSubName(subId);
		return name;
		
	}
	/**
	 * 
	 * @Title: delRaQuestions
	 * @Description: TODO(单选题型的删除)
	 * @param @param radioId
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delRaQuestions.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String delRaQuestions(int radioId){
		int count=questionService.delRaQuestions(radioId);
		String errorMessage = "删除成功";
		if(count==0){
			errorMessage = messageSource.getMessage("DEL_QUESTION_FALSE", null,
					Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}
	/**
	 * 
	 * @Title: delchQuestions
	 * @Description: TODO(多选题型的删除)
	 * @param @param checkId
	 * @param @return
	 * @return String  返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delchQuestions.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String delchQuestions(int checkId){
		int count=questionService.delchQuestions(checkId);
		String errorMessage = "删除成功";
		if(count==0){
			errorMessage = messageSource.getMessage("DEL_QUESTION_FALSE", null,
					Locale.getDefault());
			return errorMessage;
		}
		return errorMessage;
	}
	/**
	 * 根据id获取试题信息
	 * @param checkId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getQuestionsById.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String getQuestionsById(String id,int type){
		List<RadioQuestions> radioQuestions=new ArrayList<RadioQuestions>();
		List<CheckQuestions> checkQuestions=new ArrayList<CheckQuestions>();
		int questionId=Integer.valueOf(id);
		String questionInfo ="获取错误";
	    if(type==1){
	    	radioQuestions=questionService.getRaQuestionById(questionId);
	        questionInfo = JSONArray.fromObject(radioQuestions).toString();
	    }else if(type==2){
	    	checkQuestions=questionService.getChQuestionById(questionId);
	    	questionInfo = JSONArray.fromObject(checkQuestions).toString();
	    }
		return questionInfo;
	}
	/**
	 * 修改试题
	 * @param checkQuestions
	 * @param radisQuestions
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateQuestions.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
    public String updateQuestions(CheckQuestions checkQuestions,RadioQuestions radisQuestions,int type){
		if(type==1){
			questionService.updateRaQuestion(radisQuestions);
		}else if(type==2){
			questionService.updateChQuestion(checkQuestions);
		}
		return null;
	}
	@ResponseBody
	@RequestMapping(value = "/getAllsub.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")	
	public String getAllsub(){
		List<Subject> subList=questionService.getAllsub();
		String subInfo = JSONArray.fromObject(subList).toString();
		return subInfo;
		
	}
}
