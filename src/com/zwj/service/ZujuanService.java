package com.zwj.service;

import java.util.List;

import com.zwj.model.SubjectTest;
import com.zwj.model.ZuJuan;



public interface ZujuanService {

	int setZuJuan(ZuJuan zuJuan);

	List<SubjectTest> zujuanInfo();

	List<ZuJuan> subTestInfo(ZuJuan zuJuan);

	List<ZuJuan> subTestInfo1(ZuJuan zuJuan);

	void delTestInfo(int id);


	
}
