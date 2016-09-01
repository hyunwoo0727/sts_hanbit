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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;


@Controller
@SessionAttributes({"user","ctp"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired 
	private MemberServiceImpl mService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("context") String ctp,@RequestParam("userid") String id,
			@RequestParam("userpw") String pw, Locale locale,Model model,
			HttpSession session) {
		logger.info("GO TO: {}","login");
		logger.info("LOGIN ID : {}", id);
		logger.info("LOGIN PW : {}", pw);
		MemberVO memVO = new MemberVO();
		memVO.setId(id);
		memVO.setPw(pw);
		SubjectMemberVO smVO = mService.login(memVO);
		if(smVO!=null){
			model.addAttribute("user", smVO);	
			model.addAttribute("ctp", ctp);
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
		logger.info("GO TO : {}","find");
		logger.info("KEYWOD : " + keyword);
		logger.info("OPTION : " + option );
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
		logger.info("GO TO : {}","main");
		
		return "admin:member/content.tiles";
	} 
	@RequestMapping("/regist")
	public String moveRegist(Locale locale, Model model) {
		logger.info("GO TO : {}","regist");
		
		return "public:member/regist.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail(Locale locale, Model model) {
		logger.info("GO TO : {}","detail");
		
		return "admin:member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate(Locale locale, Model model) {
		logger.info("GO TO : {}","update");
		
		return "admin:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(Locale locale, Model model) {
		logger.info("GO TO : {}","delete");
		return "admin:member/open.tiles";
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
}
