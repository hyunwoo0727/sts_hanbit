package com.hanbit.web.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.constants.Values;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Pagination;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller
@SessionAttributes({"user","ctp"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl mService;
	@Autowired Command command;
	@Autowired Retval retval;
	@Autowired MemberDTO member;
	
	@RequestMapping("/logined/header")
	public String loginHeader(){
		logger.info("GO TO: {}","LOGINED HEADER");
		return "user/header.jsp";
	}
		
	@RequestMapping(value = "/login",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody MemberDTO login(@RequestBody MemberDTO param,HttpServletRequest req,Model model) {
		logger.info("GO TO: {}","login");
		logger.info("LOGIN ID : {}", param.getMemId());
		logger.info("LOGIN PW : {}", param.getPw());
		MemberDTO user = mService.login(param);
		String context = req.getContextPath();
		if(user!=null){
			model.addAttribute("user", user);	
			model.addAttribute("ctp", context);
			model.addAttribute("img", context+"/resources/img");
			model.addAttribute("css", context+"/resources/css");
			model.addAttribute("js", context+"/resources/js");
			model.addAttribute("font", context+"/resources/fonts");
			logger.info("===LOGIN SUCCESS MOVE MAIN===");
			model.addAttribute("user", user);
			return user;
		}
		logger.info("===LOGIN FAIL RETURN LOGIN===");
		return member;
	}
	@RequestMapping(value="/count/{keyField}",consumes="application/json")
	public Model count(@PathVariable String keyField, Model model){
		logger.info("TO COUNT CONDITION IS : {}","keyField");
	//	model.addAttribute("count",mService.count());
		return model;
	}
	@RequestMapping("/search/{keyField}/{keyword}")
	public MemberDTO find(@PathVariable("keyField") String keyField,
		 	@RequestParam("keyword") String keyword,Model model){
		logger.info("GO TO : {}","find");
		logger.info("KEYWOD : " + keyword);
		logger.info("keyField : " + keyField );
		command.setKeyField(keyField);
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
	public @ResponseBody MemberDTO moveDetail(@ModelAttribute("user") MemberDTO user) {
		logger.info("SHOW USER : {}","detail");
		System.out.println("유쟈디테일 " + user);
		return user;
	} 
	@RequestMapping("/a_detail")
	public String moveAdminDetail(@RequestParam("key") String key, Locale locale, Model model) {
		logger.info("GO TO : {}","admin detail");
	/*	SubjectMemberVO smVO = mService.findSmById(key);
		model.addAttribute("user", smVO);*/
		return "admin:admin/detail.tiles";
	} 
	@RequestMapping(value="/update",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody Retval update(@RequestBody MemberDTO param,Model model) {
		logger.info("EXEC MEMBER : {}","UPDATE");
		retval.setFlag(mService.updateStudent(param));
		if(retval.getFlag().equalsIgnoreCase("SUCCESS")){
			command.setKeyField("mem_id");
			command.setKeyword(param.getMemId());
			model.addAttribute("user", mService.findOne(command));
		}
		return retval;
	}
	@RequestMapping("/unregist")
	public @ResponseBody Retval unRegist(@RequestParam("pw") String pw,HttpSession session) {
		logger.info("EXEC MEMBER : {}","UNREGIST");
		MemberDTO memDto = (MemberDTO) session.getAttribute("user");
		retval.setFlag("UNMATCH");
		if(memDto.getPw().equals(pw)){
			retval.setFlag(mService.deleteStudent(memDto.getMemId()));		
		}
		return retval;
	} 
	@RequestMapping("/logout")
	public String logout(SessionStatus status, Locale locale, Model model) {
		logger.info("GO TO : {}","logout");
		status.setComplete();
		logger.info("SESSION IS : {}","CLEAR");
		return "redirect:/";
	} 
	@RequestMapping(value="/list/{strPgNum}",method=RequestMethod.GET)
	public String studentList(@PathVariable String strPgNum,Model model) {
		logger.info("EXEC MEMBER : {}","SHOW STUDENT LIST");
		int pgNum = Integer.parseInt(strPgNum);
		int totCount = mService.studentCnt().getCount();
		int totPg = Pagination.getTotPg(totCount);
		int startPg = Pagination.getStartPg(pgNum);
		int lasgPg = Pagination.getLastPg(totPg, startPg);
		int[] rows = Pagination.getStartEndRow(totCount, pgNum, Values.PG_SIZE);
		command.setStart(rows[0]);
		command.setEnd(rows[1]);
		model.addAttribute("totCount", totCount);
		model.addAttribute("pgSize", Values.PG_SIZE);
		model.addAttribute("pgNum", pgNum);
		model.addAttribute("startPg",startPg);
		model.addAttribute("lastPg",lasgPg);
		model.addAttribute("totPg",totPg);
		model.addAttribute("list", mService.list(command));
		return "admin:user/list.tiles";
	}
	@RequestMapping("/search")
	public String search(@RequestParam("keyField") String keyField,
			@RequestParam("keyword") String keyword,Model model) {
		logger.info("EXEC MEMBER : {}","search");
		command.setKeyword(keyword);
		command.setKeyField(keyField);
		List<MemberDTO> list = mService.find(command);
		int pgNum = 1;
		int totCount = list.size();
		int totPg = Pagination.getTotPg(totCount);
		int startPg = Pagination.getStartPg(pgNum);
		int lasgPg = Pagination.getLastPg(totPg, startPg);
		model.addAttribute("totCount", totCount);
		model.addAttribute("pgSize", Values.PG_SIZE);
		model.addAttribute("pgNum", pgNum);
		model.addAttribute("startPg",startPg);
		model.addAttribute("lastPg",lasgPg);
		model.addAttribute("totPg",totPg);
		model.addAttribute("list", list);
		return "admin:user/list.tiles";
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
