package com.hanbit.web.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping("/main")
	public String moveMain(Locale locale, Model model){
		logger.info("GO TO {}", "main");
		return "admin:account/content.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail(Locale locale, Model model){
		logger.info("GO TO {}", "detail");
		return "user:account/detail.tiles";
	}
	@RequestMapping("/open")
	public String moveOpen(Locale locale, Model model){
		logger.info("GO TO {}", "open");
		return "user:account/open.tiles";
	}
	@RequestMapping("/transaction")
	public String moveDeposit(Locale locale, Model model){
		logger.info("GO TO {}", "transaction");
		return "user:account/transaction.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model){
		logger.info("GO TO {}", "update");
		return "admin:account/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model){
		logger.info("GO TO {}", "delete");
		return "user:account/open.tiles";
	}
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model){
		logger.info("GO TO {}", "list");
		return "admin:account/list.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model){
		logger.info("GO TO {}", "search");
		return "admin:account/search.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model){
		logger.info("GO TO {}", "count");
		return "admin:account/count.tiles";
	}
}
