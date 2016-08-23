package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :GradeDao.java
 * @story  :
*/

public class GradeDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static GradeDAO instance = new GradeDAO();
	
	private GradeDAO() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE,Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static GradeDAO getInstance(){
		return instance;
	}
	public int insert(GradeBean grade) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO GRADE(SEQ,GRADE,JAVA,SQL,HTML,JAVASCRIPT,ID,EXAM_DATE) ");
		sb.append("VALUES(SEQ.NEXTVAL,?,?,?,?,?,?,?)");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, grade.getGrade());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getHtml());
			pstmt.setInt(5, grade.getJavascript());
			pstmt.setString(6, grade.getId());
			pstmt.setString(7, grade.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String seq) {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM GRADE WHERE SEQ="+seq);
		return exeUpdate(sb.toString());
	}
	
	public int exeUpdate(String sql){
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			updateResult = stmt.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateResult;
	}
	
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
		return findById(null);
	}
	public int count(String examDate) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM GRADE WHERE EXAM_DATE = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examDate);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public GradeBean findBySeq(String seq) {
		String sql = "SELECT * FROM GRADE WHERE SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(seq));
			rs = pstmt.executeQuery();
			if(rs.next()){
				GradeBean tempBean = new GradeBean(rs.getString("ID"),rs.getString("EXAM_DATE"),
				rs.getString("JAVA"),rs.getString("SQL"),rs.getString("HTML"),rs.getString("JAVASCRIPT"));
				tempBean.setSeq(rs.getInt("SEQ"));
				tempBean.setGrade(rs.getString("GRADE"));
				return tempBean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<GradeBean> findById(String id) {
		// TODO Auto-generated method stub
		List<GradeBean> tempList = new ArrayList<GradeBean>();
		String sql="";
		if(id!=null){
			sql = "SELECT * FROM GRADE WHERE ID=?";
		}else{
			sql = "SELECT * FROM GRADE ORDER BY SEQ";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			if(id!=null){
				pstmt.setString(1, id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				GradeBean gBean = new GradeBean(rs.getString("ID"),rs.getString("EXAM_DATE"),
				rs.getString("JAVA"),rs.getString("SQL"),rs.getString("HTML"),rs.getString("JAVASCRIPT"));
				gBean.setSeq(rs.getInt("SEQ"));
				gBean.setGrade(rs.getString("GRADE"));
				tempList.add(gBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	public int update(String[] split) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "UPDATE GRADE SET "+split[0]+"=? WHERE SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, split[1]);
			pstmt.setString(2, split[2]);
			result = pstmt.executeUpdate();
			GradeBean tempBean = findBySeq(split[2]);
			if(tempBean!=null){
				tempBean.setGrade(GradeServiceImpl.getGrade(tempBean));
			}
			sql = "UPDATE GRADE SET GRADE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tempBean.getGrade());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
