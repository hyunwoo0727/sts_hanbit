package com.hanbit.web.subject;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectService.java
 * @story  :
*/

public interface SubjectService {
	public void insert(SubjectBean subBean);
	public SubjectBean findById(String id);
}
