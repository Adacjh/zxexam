package com.zwj.controller;

import java.util.List;
import java.util.Locale;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwj.model.SubjectTest;
import com.zwj.model.ZuJuan;
import com.zwj.service.ZujuanService;

@Controller
@RequestMapping("/test")
public class ZujuanController {

	@Autowired
	private ZujuanService zujuanService;
	@Autowired
	private ResourceBundleMessageSource messageSource;// 注入国际
/**
 * 
 * @Title: addTest
 * @Description: TODO(自动组卷)
 * @param @param zuJuan
 * @param @return
 * @return String  返回类型
 * @throws
 */
	@ResponseBody
	@RequestMapping(value = "/addTest.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addTest(ZuJuan zuJuan) {
		int count = zujuanService.setZuJuan(zuJuan);
		String errorMessage = "";
		if (count == 1) {
			errorMessage = messageSource.getMessage("RADIO_SIZE_BEYOND", null,
					Locale.getDefault());
			return errorMessage;
		} else if (count == 2) {
			errorMessage = messageSource.getMessage("CHECK_SIZE_BEYOND", null,
					Locale.getDefault());
			return errorMessage;
		} else if (count == 0) {
			errorMessage = "success";
			return errorMessage;
		}else if(count==1001){
			errorMessage = messageSource.getMessage("TEST_TYPE_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}else if(count==1002){
			errorMessage = messageSource.getMessage("TEST_DIFF_NULL", null,
					Locale.getDefault());
			return errorMessage;
		}else if(count==1003){
			errorMessage = messageSource.getMessage("ALL_IS_EXIST", null,
					Locale.getDefault());
			return errorMessage;	
		}
		
		return errorMessage;
	}
/**
 * 
 * @Title: zujuanInfo
 * @Description: TODO(查看试卷信息)
 * @param @param number
 * @param @return
 * @return String  返回类型
 * @throws
 */
	@ResponseBody
	@RequestMapping(value = "/zujuanInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String zujuanInfo(int number) {
		List<SubjectTest> subjectList = zujuanService.zujuanInfo();
		for (int i = 0; i < subjectList.size(); i++) {
			subjectList.get(i).setSubjectDate(
					subjectList.get(i).getSubjectDate().substring(0, 10));
		}
		String zujuanInfo = JSONArray.fromObject(subjectList).toString();

		return zujuanInfo;

	}
/**
 * 
 * @Title: subTestInfo
 * @Description: TODO(试卷中查看单选题)
 * @param @param zuJuan
 * @param @return
 * @return String  返回类型
 * @throws
 */
	@ResponseBody
	@RequestMapping(value = "/subTestInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String subTestInfo(ZuJuan zuJuan) {
		List<ZuJuan> testList = zujuanService.subTestInfo(zuJuan);

		String subTestInfo = JSONArray.fromObject(testList).toString();

		return subTestInfo;
	}
/**
 * 
 * @Title: subTestInfo1
 * @Description: TODO(试卷中查看多选题信息)
 * @param @param zuJuan
 * @param @return
 * @return String  返回类型
 * @throws
 */
	@ResponseBody
	@RequestMapping(value = "/subTestInfo1.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String subTestInfo1(ZuJuan zuJuan) {
		List<ZuJuan> testList1 = zujuanService.subTestInfo1(zuJuan);

		String subTestInfo1 = JSONArray.fromObject(testList1).toString();

		return subTestInfo1;
	}

	@ResponseBody
	@RequestMapping(value = "/delTestInfo.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String delTestInfo(int id) {
		try {
			zujuanService.delTestInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
