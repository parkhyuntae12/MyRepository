package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword,HttpSession session,Model model){
		int result = memberService.login(mid, mpassword);
		if(result==MemberService.LOGIN_FAIL_MPASSWORD){
			model.addAttribute("error","LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		}else if(result==MemberService.LOGIN_FAIL_MID){
			model.addAttribute("error","LOGIN_FAIL_MID");
			return "member/loginForm";
		}else{
			session.setAttribute("login", mid);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/findMid",method=RequestMethod.GET)
	public String findMidForm(){
		return "member/findMidForm";
	}
	@RequestMapping(value="/findMid",method=RequestMethod.POST)
	public String findMid(String memail,Model model,HttpSession session){
		String mid = memberService.findMid(memail);
		if(mid==null){
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);//session방식으로 넘기는 방법
		return "redirect:/member/login";
		//return "redirect:/member/login?mid="+mid;//get방식으로 넘기는 방법
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String joinForm(){
		return "member/joinForm";
	}
//서비스에서는 try/catch문을 쓰면 안된다(컨트롤러에서) 
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Member member){
		try{
			int result = memberService.join(member);
			return "redirect:/member/login";
		}catch(Exception e){
			return "member/joinForm";
		}
	}
	/*@RequestMapping(value="/findMpassword", method=RequestMethod.POST)
	public String findMpassword(String mid, String memail,Model model,HttpSession session){
		String mpassword = memberService.findMpassword(mid, memail);
		if(mid)
		return "member/findMpasswordForm";
	}*/
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String mid = (String) session.getAttribute("login");
		int result = memberService.logout(mid);
		if(result==MemberService.LOGOUT_SUCCESS){
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(String mpassword,HttpSession session,Model model){
		//정보를 볼때 비번을 한번더 묻기로 결정했으니 사용자에게 받아야 한다
		String mid = (String) session.getAttribute("login");
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member",member);//model은 jsp로 데이터를 보내는 역할(request범위에 저장)
		return "member/info";
	}
}