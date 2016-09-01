package com.hanbit.web.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
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
	
}
