package com.hanbit.web.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("ctp")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/main")
	public String moveMain(HttpServletRequest req, Locale locale,Model model){
		logger.info("AdminController moveMain() locale is {}.", locale);
		model.addAttribute("ctp", req.getContextPath());
		return "admin:admin/content.tiles";
	}
	@RequestMapping("/header")
	public String adminHeader(){
		logger.info("LOAD ADMIN : {}","HEADER");
		return "admin/header.jsp";
	}
	@RequestMapping("/nav")
	public String adminNav(){
		logger.info("LOAD ADMIN : {}","NAV");
		return "admin/nav.jsp";
	}
}
