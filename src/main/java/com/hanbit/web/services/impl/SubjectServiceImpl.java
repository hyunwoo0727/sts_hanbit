package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.services.SubjectService;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectServiceImpl.java
 * @story  :
*/
@Service
public class SubjectServiceImpl implements SubjectService{

	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	
	private SubjectServiceImpl() {
	}
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	/*@Override
	public void insert(SubjectDTO subBean) {
	}
	@Override
	public SubjectDTO findByPk(int subjSeq) {
		return null;
	}*/
}
