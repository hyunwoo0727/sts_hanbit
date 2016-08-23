package com.hanbit.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :ParamMap.java
 * @story  :
*/

public class ParamMap {
	public static String getValues(HttpServletRequest request,String name){
		StringBuffer buff = new StringBuffer();
		String[] values = (String[]) request.getParameterMap().get(name);
		int i=0;
		for (; i < values.length; i++) {
			buff.append(values[i]+":");
		}
		return buff.substring(0, buff.length()-1).toString();
	}
}
