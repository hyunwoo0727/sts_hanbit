package com.hanbit.web.util;

/**
 * @date   :2016. 7. 5.
 * @author :HyunWoo Lee
 * @file   :DatabaseFactory.java
 * @story  :
*/

public class DatabaseFactory {
	public static Database createDatabase(Vendor vendor,String id,String pw){
		String driver = "",url="";
		switch (vendor) {
		case ORACLE:
			driver = Constants.ORACLE_DRIVER;
			url = Constants.ORACLE_URL;
			break;
		case MYSQL:
			driver = Constants.MYSQL_DRIVER;
			url = Constants.MYSQL_URL;
			break;
		case MSSQL:
			break;
		case MARIADB:
			break;
		default:
			break;
		}
		return new Database(driver,url,id,pw);
	}
}
