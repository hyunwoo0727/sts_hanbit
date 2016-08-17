package com.hanbit.web.global;

/**
 * @date   :2016. 7. 19.
 * @author :HyunWoo Lee
 * @file   :Test.java
 * @story  :
*/

public class Test {
	public static void main(String[] args) {
		String[] values = {"java","html","c++","sql"};
		String result = "";
		int i=0;
		for (; i < values.length; i++) {
			result += (i==values.length-1) ? values[i] : values[i]+":";
		}
		System.out.println(result);
	}
}
