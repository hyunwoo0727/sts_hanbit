package com.hanbit.web.subject;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectServiceImpl.java
 * @story  :
*/

public class SubjectServiceImpl implements SubjectService{

	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	private SubjectDAO dao = SubjectDAO.getInstance();
	
	private SubjectServiceImpl() {
	}
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void insert(SubjectBean subBean) {
		dao.insert(subBean);
	}
	@Override
	public SubjectBean findById(String id) {
		return dao.findById(id);
	}
}
