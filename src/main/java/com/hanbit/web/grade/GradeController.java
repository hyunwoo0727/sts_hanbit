package com.hanbit.web.grade;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.bank.AccountController;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping("/main")
	public String moveMain(Locale locale, Model model){
		logger.info("GradeController moveMain() locale is {}.", locale);
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model){
		logger.info("GradeController moveRegist() locale is {}.", locale);
		return "admin:grade/regist.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model){
		logger.info("GradeController moveUpdate() locale is {}.", locale);
		return "admin:grade/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model){
		logger.info("GradeController moveDelete() locale is {}.", locale);
		return "admin:grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model){
		logger.info("GradeController moveList() locale is {}.", locale);
		return "admin:grade/list.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model){
		logger.info("GradeController moveCount() locale is {}.", locale);
		return "admin:grade/count.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model){
		logger.info("GradeController moveSearch() locale is {}.", locale);
		return "admin:grade/search.tiles";
	}
}
