package com.hanbit.web.grade;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class GradeVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id,grade,examDate;
	private int    seq,java,sql,html,javascript;
	
	public GradeVO(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getJavascript() {
		return javascript;
	}
	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}
	@Override
	public String toString() {
		return "성적표 [ No : " + seq + " 시험일 : " + examDate + ",ID : " + id + ", 학점 : " + grade + "\n  "
				+ "	JAVA : " + java + ", SQL : " + sql
				+ ", HTML5 : " + html + ", JAVASCRIPT : " + javascript + " ]";
	}
}
