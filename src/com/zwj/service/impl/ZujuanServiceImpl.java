package com.zwj.service.impl;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;













import com.zwj.dao.ZujuanDao;
import com.zwj.model.CheckQuestions;
import com.zwj.model.RadioQuestions;
import com.zwj.model.Score;
import com.zwj.model.SubjectTest;
import com.zwj.model.ZuJuan;
import com.zwj.service.ZujuanService;

@Service("ZujuanService")
public class ZujuanServiceImpl implements ZujuanService {
@Autowired
private ZujuanDao zujuanDao;

@Override
public int setZuJuan(ZuJuan zuJuan) {
	if(zuJuan.getZujuanType().indexOf("0")!=-1){
		return 1001;
	}
	if(zuJuan.getZujuanDifficulty().indexOf("0")!=-1){
		return 1002;
	}
	int subName=zuJuan.getSubName();
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");//试卷编号
	String hehe = dateFormat.format( now ); //格式转换
	String[] que = zuJuan.getZujuanType().split(",");
	String[] dif = zuJuan.getZujuanDifficulty().split(",");
	String[] num = zuJuan.getZujuanNumber().split(",");
	String[] sco = zuJuan.getZujuanScore().split(",");
	if(num.length!=sco.length){
		return 1003;
	}
	int len = que.length;
	for (int i = 0; i < len; i++) {
		ZuJuan zujuan1=new ZuJuan();
		zujuan1.setZujuanType(que[i]);
		zujuan1.setZujuanDifficulty(dif[i]);
		zujuan1.setZujuanNumber(num[i]);
		zujuan1.setZujuanScore(sco[i]);
		int number=Integer.parseInt(zujuan1.getZujuanNumber());
		int difficult=Integer.parseInt(zujuan1.getZujuanDifficulty());
		if(zujuan1.getZujuanType().equals("1")){
			List<RadioQuestions> questionList=zujuanDao.setRaQuestionTest(number,difficult,subName);//获取单选题
			if(questionList.size()<Integer.valueOf(num[i])){//判断是否超出条数
				return 1;
			}
			for(int j=0;j<questionList.size();j++){//将抽取出的试题存储到试卷表中
				zujuan1.setQuestionId(questionList.get(j).getRadioId());
				zujuan1.setQuestionBh(hehe);
				int count=zujuanDao.addZujuanRadio(zujuan1);
			}
		}
		if(zujuan1.getZujuanType().equals("2")){
			List<CheckQuestions> questionList=zujuanDao.setCkQuestionTest(number,difficult,subName);
			if(questionList.size()<Integer.valueOf(num[i])){
				return 2;
			}
			for(int j=0;j<questionList.size();j++){
				zujuan1.setQuestionId(questionList.get(j).getCheckId());
				zujuan1.setQuestionBh(hehe);
				int count=zujuanDao.addZujuanCheck(zujuan1);
				
			}
		}
	}
	/*
	 * 存储到试卷表
	 */
	SubjectTest subjectTest=new SubjectTest();
	subjectTest.setSubjectName(zuJuan.getZujuanName());
	subjectTest.setSubjectBianhao(hehe);
	subjectTest.setTestTime(zuJuan.getTestTime());
	subjectTest.setSubName(zuJuan.getSubName()+"");
	zujuanDao.addSubTest(subjectTest);
	return 0;
}

@Override
public List<SubjectTest> zujuanInfo() {
	// TODO Auto-generated method stub
	return zujuanDao.zujuanInfo();
}

@Override
public List<ZuJuan> subTestInfo(ZuJuan zuJuan) {
	// TODO Auto-generated method stub
	return zujuanDao.subTestInfo(zuJuan);

}

@Override
public List<ZuJuan> subTestInfo1(ZuJuan zuJuan) {
	// TODO Auto-generated method stub
	return zujuanDao.subTestInfo1(zuJuan);

}

@Override
public void delTestInfo(int id) {
	// TODO Auto-generated method stub
	zujuanDao.delTestInfo(id);
}

}
