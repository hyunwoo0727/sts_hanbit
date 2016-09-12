package com.hanbit.web.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping("/main")
	public String moveMain(Locale locale, Model model){
		logger.info("GO TO: {}","main");
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model){
		logger.info("GO TO: {}","regist");
		return "admin:grade/regist.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model){
		logger.info("GO TO: {}","update");
		return "admin:grade/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model){
		logger.info("GO TO: {}","delete");
		return "admin:grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model){
		logger.info("GO TO: {}","list");
		return "admin:grade/list.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model){
		logger.info("GO TO: {}","count");
		return "admin:grade/count.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model){
		logger.info("GO TO: {}","search");
		return "user:grade/search.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail(Locale locale, Model model){
		logger.info("GO TO: {}","detail");
		return "user:grade/detail.tiles";
	}
}
