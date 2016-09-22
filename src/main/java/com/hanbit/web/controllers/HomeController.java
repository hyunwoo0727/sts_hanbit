package com.hanbit.web.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.services.impl.GradeServiceImpl;
import com.hanbit.web.services.impl.MemberServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired 
	private GradeServiceImpl gService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/public/header")
	public String publicHeader(){
		logger.info("GO TO: {}","PUBLIC HEADER");
		return "public/header.jsp";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! {}.", DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale).format(new Date()));

		return "public:public/content.tiles";
	}
	@RequestMapping("/school/main")
	public String schoolInfo(){
		logger.info("GO TO {}","school main");
		return "public:public/school_info.tiles";
	}
	@RequestMapping("/public/contact")
	public String moveContact(){
		logger.info("GO TO {}","contact");
		return "public:public/contact.tiles";
	}
	@RequestMapping("/public/freeboard")
	public String moveFreeboard(){
		logger.info("GO TO {}","freeboard");
		return "public:public/freeboard.tiles";
	}
}
