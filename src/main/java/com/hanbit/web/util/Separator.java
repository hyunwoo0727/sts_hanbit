package com.hanbit.web.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date   :2016. 7. 21.
 * @author :HyunWoo Lee
 * @file   :Separator.java
 * @story  :
*/

public class Separator {
	public static CommandFactory factory = new CommandFactory();
	public static Command command;
	
	public static Command init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		String temp0 = path.split("/")[0];
		System.out.println("TEMP0 : " + temp0);
		String temp = path.split("/")[1];
		System.out.println("TEMP : " +temp);
		String directory = temp.substring(0, temp.indexOf("."));
		Enumeration<String> en = request.getParameterNames();
		List<String> list = new ArrayList<String>();
		while (en.hasMoreElements()) {
			list.add((String) en.nextElement());
		}
		String action = list.contains("action") ? request.getParameter("action") : "move";
		String page = list.contains("page") ? request.getParameter("page") : "main";
		String pageNo = list.contains("pageNo")? request.getParameter("pageNo") : "1";
		String keyword = list.contains("keyword")? request.getParameter("keyword") : "lostChild";
		
		System.out.println("DIRECTORY : " + directory);
		System.out.println("CMD : " + action + " PAGE : " + page);
		command = factory.createCommand(directory,action,page);
		return command;
	}
}
