package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MajorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int majorSeq;
	private String title;
	public int getMajorSeq() {
		return majorSeq;
	}
	public void setMajorSeq(int majorSeq) {
		this.majorSeq = majorSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "MajorVO [majorSeq=" + majorSeq + ", title=" + title + "]";
	}
}
