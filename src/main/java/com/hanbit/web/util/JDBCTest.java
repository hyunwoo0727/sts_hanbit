package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @date   :2016. 6. 30.
 * @author :HyunWoo Lee
 * @file   :JDBCTest.java
 * @story  :
*/

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select id from test",result="";
		
		List<String> list = new ArrayList<String>();
		try {
			Class.forName(Constants.ORACLE_DRIVER); 
			// DriverManager는 어떤 드라이버가 올줄 모름.. 위에꺼 호출하면 생성된 드라이버가 매니저에 세팅됨
			// 어디서? 스태틱 초기화 블록에서...
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = rs.getString("id");
				list.add(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(list);
	}
}
