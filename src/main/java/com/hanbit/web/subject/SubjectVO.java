package com.hanbit.web.subject;

import java.io.Serializable;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectBean.java
 * @story  :
*/

public class SubjectVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id,major,subjects;
	private int subjSeq;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSubjSeq() {
		return subjSeq;
	}

	public void setSubjSeq(int subjSeq) {
		this.subjSeq = subjSeq;
	}

	@Override
	public String toString() {
		return "SubjectBean [id=" + id + ", major=" + major + ", subjects=" + subjects + ", subjSeq=" + subjSeq + "]";
	}
	
}
