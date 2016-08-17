package com.hanbit.web.global;


/**
 * @date   :2016. 7. 21.
 * @author :HyunWoo Lee
 * @file   :CommandFactory.java
 * @story  :
*/

public class CommandFactory {
	
	public Command createCommand(String directory,String action,String page){
		return new Command(directory, action,page);
	}
}
