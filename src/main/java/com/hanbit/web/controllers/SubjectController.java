package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/detail")
	public String moveDetatil(@RequestParam("key") String key){
		logger.info("KEY : {}",key);
		logger.info("GO TO : {}","detail");
		return "admin:subject/detail.tiles";
	}
}
