package com.hanbit.web.controllers;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller
@SessionAttributes({"user","ctp"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberServiceImpl mService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("context") String ctp,@RequestParam("userid") String memId,
			@RequestParam("userpw") String pw, Locale locale,Model model,
			HttpSession session) {
		logger.info("GO TO: {}","login");
		logger.info("LOGIN ID : {}", memId);
		logger.info("LOGIN PW : {}", pw);
		MemberDTO memDto = new MemberDTO();	
		memDto.setMemId(memId);
		memDto.setPw(pw);
		memDto = mService.login(memDto);
		if(memDto!=null){
			model.addAttribute("user", memDto);	
			model.addAttribute("ctp", ctp);
			model.addAttribute("img", ctp+"/resources/img");
			model.addAttribute("css", ctp+"/resources/css");
			model.addAttribute("js", ctp+"/resources/js");
			model.addAttribute("font", ctp+"/resources/fonts");
			logger.info("===LOGIN SUCCESS MOVE MAIN===", pw);
			return "user:user/content.tiles";
		}
		logger.info("===LOGIN SUCCESS RETURN LOGIN===", pw);
		return "public:member/login.tiles";
	}
	
	@RequestMapping("/find")
	public String find(@RequestParam("keyword") String keyword,
		 	@RequestParam("select_option") String option,Model model){
		logger.info("GO TO : {}","find");
		logger.info("KEYWOD : " + keyword);
		logger.info("OPTION : " + option );
	//	SubjectMemberVO smVO = mService.findSmById(keyword);
		MemberDTO smVO = new MemberDTO();
		if(smVO!=null){
		//	logger.info("member name " + smVO.getName());
			model.addAttribute("user", smVO);
		}else{
			logger.info("member name 없어");
			return "admin:member/search.tiles";
		}
		return "admin:member/detail.tiles";
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
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model) {
		logger.info("GO TO : {}","regist");
		
		return "public:member/regist.tiles";
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
	@RequestMapping("/login")
	public String login(Locale locale, Model model) {
		logger.info("GO TO : {}","login");
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String moveLogout(HttpSession session, Locale locale, Model model) {
		logger.info("GO TO : {}","logout");
		session.invalidate();
		return "public:public/content.tiles";
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
	@RequestMapping("/count")
	public String moveCount(Locale locale, Model model) {
		logger.info("GO TO : {}","count");
		return "admin:member/count.tiles";
	}
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
