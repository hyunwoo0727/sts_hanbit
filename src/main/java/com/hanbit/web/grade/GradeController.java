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
		return "grade/content.tiles";
	}
}
