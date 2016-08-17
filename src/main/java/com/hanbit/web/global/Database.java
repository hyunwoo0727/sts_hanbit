package com.hanbit.web.global;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :Database.java
 * @story  :
*/

public class Database {
	private Connection conn;
	private String driver,url,id,pw;

	public Database(String driver,String url,String id,String pw) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
