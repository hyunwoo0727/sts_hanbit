package com.hanbit.web.bank;

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
		logger.info("AccountController moveMain() locale is {}.", locale);
		return "account/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model){
		logger.info("AccountController moveRegist() locale is {}.", locale);
		return "account/regist.tiles";
	}
	@RequestMapping("/deposit")
	public String moveDeposit(Locale locale, Model model){
		logger.info("AccountController moveDeposit() locale is {}.", locale);
		return "account/deposit.tiles";
	}
	@RequestMapping("/withdraw")
	public String moveWithdraw(Locale locale, Model model){
		logger.info("AccountController moveWithdraw() locale is {}.", locale);
		return "account/withdraw.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model){
		logger.info("AccountController moveUpdate() locale is {}.", locale);
		return "account/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model){
		logger.info("AccountController moveDelete() locale is {}.", locale);
		return "account/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model){
		logger.info("AccountController moveList() locale is {}.", locale);
		return "account/list.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model){
		logger.info("AccountController moveSearch() locale is {}.", locale);
		return "account/search.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model){
		logger.info("AccountController moveCount() locale is {}.", locale);
		return "account/count.tiles";
	}
}
