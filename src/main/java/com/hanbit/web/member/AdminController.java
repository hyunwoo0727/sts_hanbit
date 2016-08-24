package com.hanbit.web.member;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/main")
	public String moveMain(Locale locale, Model model){
		logger.info("AdminController moveMain() locale is {}.", locale);
		
		return "admin:admin/content.tiles";
	}
}
