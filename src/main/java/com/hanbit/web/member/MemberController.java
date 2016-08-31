package com.hanbit.web.member;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.subject.SubjectMemberVO;


@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired 
	private MemberServiceImpl mService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("context") String ctp,@RequestParam("userid") String id,
			@RequestParam("userpw") String pw, Locale locale,Model model,
			HttpSession session) {
		logger.info("MemberController login locale is {}.", locale);
		logger.info("ID : {}", id);
		logger.info("PW : {}", pw);
		MemberVO memVO = new MemberVO();
		memVO.setId(id);
		memVO.setPw(pw);
		SubjectMemberVO smVO = mService.login(memVO);
		if(smVO!=null){
			session.setAttribute("user", smVO);	
			model.addAttribute("img", ctp+"/resources/img");
			model.addAttribute("css", ctp+"/resources/css");
			model.addAttribute("js", ctp+"/resources/js");
			model.addAttribute("font", ctp+"/resources/fonts");
			System.out.println(ctp+"ㅋㅋㅋㅋ");
			return "user:user/content.tiles";
		}
		return "public:member/login.tiles";
	}
	
	@RequestMapping("/find")
	public String find(@RequestParam("keyword") String keyword,
		 	@RequestParam("select_option") String option,Model model){
		logger.info("MemberController find()");
		logger.info("keyword : " + keyword);
		logger.info("option : " + option );
		SubjectMemberVO smVO = mService.findSmById(keyword);
		if(smVO!=null){
			logger.info("member name " + smVO.getName());
			model.addAttribute("user", smVO);
		}else{
			logger.info("member name 없어");
			return "admin:member/search.tiles";
		}
		return "admin:member/detail.tiles";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String moveMain(Locale locale, Model model) {
		logger.info("MemberController moveMain() locale is {}.", locale);
		
		return "admin:member/content.tiles";
	} 
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model) {
		logger.info("MemberController moveRegitst() locale is {}.", locale);
		
		return "public:member/regist.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail(Locale locale, Model model) {
		logger.info("MemberController moveDetail() locale is {}.", locale);
		
		return "admin:member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model) {
		logger.info("MemberController moveUpdate locale is {}.", locale);
		
		return "admin:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model) {
		logger.info("MemberController moveDelete locale is {}.", locale);
		
		return "admin:member/open.tiles";
	} 
	@RequestMapping("/moveLogin")
	public String moveLogin(Locale locale, Model model) {
		logger.info("MemberController moveLogin locale is {}.", locale);
		
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String moveLogout(HttpSession session, Locale locale, Model model) {
		logger.info("MemberController moveLogout locale is {}.", locale);
		session.removeAttribute("user");
		return "public:public/content.tiles";
	} 
	@RequestMapping("/list")
	public String moveList(Locale locale, Model model) {
		logger.info("MemberController moveList locale is {}.", locale);
		
		return "admin:member/list.tiles";
	} 
	@RequestMapping("/search")
	public String moveSearch(Locale locale, Model model) {
		logger.info("MemberController moveSearch locale is {}.", locale);
		
		return "admin:member/search.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model) {
		logger.info("MemberController moveCount locale is {}.", locale);
		
		return "admin:member/count.tiles";
	}
}
