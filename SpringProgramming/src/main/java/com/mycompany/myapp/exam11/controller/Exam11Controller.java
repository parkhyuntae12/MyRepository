package com.mycompany.myapp.exam11.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam11.dto.Board;
import com.mycompany.myapp.exam11.dto.Member;
import com.mycompany.myapp.exam11.service.Exam11MemberService;

@Controller("MemberController")//이름을 넣어주지 않으면 디폴트로 맨앞글자가 소문자로 바뀐 컨트롤러이름으로 생성
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@Autowired
	private Exam11MemberService memberService;
	
	@Autowired
	private Exam11BoardService boardService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam11/index";//뷰경로(/WEB-INF/views) exam11/index  (.jsp)
	}
	
	@RequestMapping(value="/memberJoin",method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("memberJoin(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin",method=RequestMethod.POST)
	public String memberJoin(Member member){
		logger.info("memberJoin(POST) 처리");
		logger.info("join 요청 처리");
		logger.info("mid :"+member.getMid());
		logger.info("mname :"+member.getMname());
		logger.info("memail :"+member.getMemail());
		logger.info("mtel :"+member.getMtel());
		logger.info("mjob :"+member.getMjob());
		logger.info("mskill :"+Arrays.toString(member.getMskill()));
		logger.info("maddress1 :"+member.getMaddress1());
		logger.info("maddress2 :"+member.getMaddress2());
		logger.info("mbirth :"+member.getMbirth());
		
		memberService.join(member);
		
		return "redirect:/exam11/memberLogin";
	}
	
	@RequestMapping(value="/memberLoginForm",method=RequestMethod.GET)
	public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin",method=RequestMethod.POST)
	public String memberLogin(String mid,String mpassword){
		logger.info("memberLogin(POST) 처리");
		logger.info("mid :"+mid);
		logger.info("mpassword :"+mpassword);
		
		int result = memberService.login(mid,mpassword);
		if(result == Exam11MemberService.LOGIN_SUCESS){
			return "redirect:/exam11/index";
		}else if(result == Exam11MemberService.LOGIN_FAIL_MID){
			return "redirect:/exam11/memberLogin";
		}else{
			return "redirect:/exam11/memberLogin";
		}
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogout(){
		logger.info("memberLogout 처리");
		return "redirect:/exam11/index";
	}
	
	@RequestMapping(value="/board",method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWriteForm 처리");
		return "exam11/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite",method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("boardWrite 처리");
		boardService.insert(board);
		return "redirext:/exam11/index";
	}
}