package com.hanbit.web.subject;

public interface SubjectDAO {
	public int insert(SubjectVO sub);
	public int findById(String id);
	public SubjectVO findByPk(int subSeq);
}
