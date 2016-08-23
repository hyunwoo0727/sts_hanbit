package com.hanbit.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date   :2016. 7. 22.
 * @author :HyunWoo Lee
 * @file   :DispatcherServlet.java
 * @story  :
*/

public class DispatcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response,Command command) throws ServletException, IOException{
		request.getRequestDispatcher(command.getView()).forward(request, response);
	}
}
