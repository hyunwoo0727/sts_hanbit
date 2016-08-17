package com.hanbit.web.grade;

import java.io.Serializable;

public class GradeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id,grade,seq,examDate;
	private int    java,sql,html,javascript;
	
	public GradeBean(){
		
	}
	
	public GradeBean(String id, String examDate, String java, String sql, String html, String javascript) {
		this.id = id;
		this.examDate = examDate;
		this.java = Integer.parseInt(java);
		this.sql = Integer.parseInt(sql);
		this.html = Integer.parseInt(html);
		this.javascript = Integer.parseInt(javascript);;
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
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public void setSeq(int seq){
		this.seq = String.valueOf(seq);
	}
	public int getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = Integer.parseInt(java);
	}

	public int getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = Integer.parseInt(sql);
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = Integer.parseInt(html);
	}
	public int getJavascript() {
		return javascript;
	}
	public void setJavascript(String javascript) {
		this.javascript = Integer.parseInt(javascript);
	}
	
	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "성적표 [ No : " + seq + " 시험일 : " + examDate + ",ID : " + id + ", 학점 : " + grade + "\n  "
				+ "	JAVA : " + java + ", SQL : " + sql
				+ ", HTML5 : " + html + ", JAVASCRIPT : " + javascript + " ]";
	}
}
