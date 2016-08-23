package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectDAO.java
 * @story  :
*/

public class SubjectDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static SubjectDAO instance = new SubjectDAO();
	
	private SubjectDAO() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static SubjectDAO getInstance() {
		return instance;
	}
	public void insert(SubjectBean sub){
		int result = 0;
		String sql = "INSERT INTO SUBJECT(SUBJ_SEQ,ID,MAJOR,SUBJECTS) VALUES(SUBJ_SEQ.NEXTVAL,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getId());
			pstmt.setString(2, sub.getMajor());
			pstmt.setString(3, sub.getSubjects());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1){
			System.out.println("과목 추가 성공");
		}else{
			System.out.println("과목 추가 실풰");
		}
	}
	public SubjectBean findById(String id){
		String sql = "SELECT * FROM SUBJECT WHERE ID=?";
		SubjectBean subject = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				subject = new SubjectBean();
				subject.setId(rs.getString("ID"));
				subject.setMajor(rs.getString("MAJOR"));
				subject.setSubjects(rs.getString("SUBJECTS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}
}
