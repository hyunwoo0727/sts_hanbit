package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectServiceImpl.java
 * @story  :
*/
@Service
public class SubjectServiceImpl implements SubjectService{

	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	private SubjectDAOImpl sDao;
	
	private SubjectServiceImpl() {
		sDao = SubjectDAOImpl.getInstance();
	}
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void insert(SubjectVO subBean) {
		sDao.insert(subBean);
	}
	@Override
	public SubjectVO findByPk(int subjSeq) {
		return sDao.findByPk(subjSeq);
	}
}
