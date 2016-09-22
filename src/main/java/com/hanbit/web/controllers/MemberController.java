package com.hanbit.web.controllers;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller
@SessionAttributes({"user","ctp"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired MemberServiceImpl mService;
	@Autowired Command command;
	@Autowired MemberDTO memDto;
	@Autowired Retval retval;
	
	@RequestMapping("/logined/header")
	public String loginHeader(){
		logger.info("GO TO: {}","LOGINED HEADER");
		return "user/header.jsp";
	}
		
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("context") String context,@RequestParam("userid") String userid,
			@RequestParam("userpw") String userpw, Model model) {
		logger.info("GO TO: {}","login");
		logger.info("LOGIN ID : {}", userid);
		logger.info("LOGIN PW : {}", userpw);
		memDto.setMemId(userid);
		memDto.setPw(userpw);
		memDto = mService.login(memDto);
		if(!memDto.getMemId().equals("")){
			model.addAttribute("user", memDto);	
			model.addAttribute("ctp", context);
			model.addAttribute("img", context+"/resources/img");
			model.addAttribute("css", context+"/resources/css");
			model.addAttribute("js", context+"/resources/js");
			model.addAttribute("font", context+"/resources/fonts");
			logger.info("===LOGIN SUCCESS MOVE MAIN===", userpw);
			model.addAttribute("user", memDto);
			return memDto;
		}
		logger.info("===LOGIN FAIL RETURN LOGIN===", userpw);
		return memDto;
	}
	@RequestMapping(value="/count/{option}",consumes="application/json")
	public Model count(@PathVariable String option, Model model){
		logger.info("TO COUNT CONDITION IS : {}","option");
		model.addAttribute("count",mService.count());
		return model;
	}
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
		 	@RequestParam("keyword") String keyword,Model model){
		logger.info("GO TO : {}","find");
		logger.info("KEYWOD : " + keyword);
		logger.info("OPTION : " + option );
		command.setOption(option);
		command.setKeyword(keyword);
	//	SubjectMemberVO smVO = mService.findSmById(keyword);
		return mService.findOne(command);
	}
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String moveMain(HttpSession session,Locale locale, Model model) {
		logger.info("GO TO : {}","main");
		String ctp = (String) session.getAttribute("ctp");
		model.addAttribute("img", ctp+"/resources/img");
		model.addAttribute("css", ctp+"/resources/css");
		model.addAttribute("js", ctp+"/resources/js");
		model.addAttribute("font", ctp+"/resources/fonts");
		return "user:user/content.tiles";
	} 
	@RequestMapping(value="/signup",method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody Retval signUp(@RequestBody MemberDTO param) {
		logger.info("SIGN UP : {}","signup");
		logger.info("SIGN UP ID : {}",param.getMemId());
		param.setGender("MALE");
		param.setRegDate("2016-09-22");
		param.setRole("STUDENT");
		param.setProfileImg("default.jpg");
		param.setMajorSeq(1010);
		retval.setMessage(mService.regist(param));
		return retval;
	} 
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval checkDup(@PathVariable String id) {
		logger.info("CHECK DUPL : {}","checkDup");
		int result = mService.existId(id);
		if(result==1){
			logger.info("CHECK DUPL : {}","TRUE");
			retval.setFlag("TRUE");
			retval.setMessage("이미 존재");
		}else{
			logger.info("CHECK DUPL : {}","FALSE");
			retval.setFlag("FALSE");
			retval.setMessage("사용 가능");
			retval.setTemp(id);
		}
		return retval;
	} 
	@RequestMapping("/detail")
	public String moveDetail(Locale locale, Model model) {
		logger.info("GO TO : {}","detail");
		
		return "user:member/detail.tiles";
	} 
	@RequestMapping("/a_detail")
	public String moveAdminDetail(@RequestParam("key") String key, Locale locale, Model model) {
		logger.info("GO TO : {}","admin detail");
	/*	SubjectMemberVO smVO = mService.findSmById(key);
		model.addAttribute("user", smVO);*/
		return "admin:admin/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model) {
		logger.info("GO TO : {}","update");
		
		return "user:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model) {
		logger.info("GO TO : {}","delete");
		return "user:member/delete.tiles";
	} 
	/*@RequestMapping("/login")
	public String login(Locale locale, Model model) {
		logger.info("GO TO : {}","login");
		return "public:member/login.tiles";
	} */
	@RequestMapping("/logout")
	public String logout(SessionStatus status, Locale locale, Model model) {
		logger.info("GO TO : {}","logout");
		status.setComplete();
		logger.info("SESSION IS : {}","CLEAR");
		return "redirect:/";
	} 
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model) {
		logger.info("GO TO : {}","moveList");
		return "admin:member/list.tiles";
	} 
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model) {
		logger.info("GO TO : {}","search");
		return "admin:member/search.tiles";
	} 
	/*@RequestMapping("/count")
	public String moveCount(Locale locale, Model model) {
		logger.info("GO TO : {}","count");
		return "admin:member/count.tiles";
	}*/
	@RequestMapping("/rsp")
	public String moveRsp(Locale locale, Model model) {
		logger.info("GO TO : {}","rsp");
		return "user:user/rsp.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto(Locale locale, Model model) {
		logger.info("GO TO : {}","lotto");
		return "user:user/lotto.tiles";
	}
	@RequestMapping("/kaup")
	public String moveKaup(Locale locale, Model model) {
		logger.info("GO TO : {}","kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/content")
	public String moveUserContent(HttpSession session,Model model) {
		logger.info("GO TO : {}","content");
		String ctp = (String) session.getAttribute("ctp");
		model.addAttribute("img", ctp+"/resources/img");
		model.addAttribute("css", ctp+"/resources/css");
		model.addAttribute("js", ctp+"/resources/js");
		model.addAttribute("font", ctp+"/resources/fonts");
		return "user:user/content.tiles";
	}
}
