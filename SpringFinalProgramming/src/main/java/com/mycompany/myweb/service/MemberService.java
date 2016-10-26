package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;//세가지 이상의 경우에는 상수를 정해줘야 한다
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;
	
	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL_MID=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL_MID=1;
	
	public static final int WITHDRAW_FAIL=0;
	public static final int WITHDRAW_SUCCESS=1;
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member){//정상실행과 예외만 존재할때 void로 리턴해도 된다
		 memberDao.insert(member);//예외처리 노노
		 return JOIN_SUCCESS;
	}
	public int  login(String mid,String mpassword,HttpSession session){
		Member member = memberDao.selectByMid(mid);
		if(member==null) {return LOGIN_FAIL_MID;}
		if(member.getMpassword().equals(mpassword)==false){return LOGIN_FAIL_MPASSWORD;}
		session.setAttribute("login", mid);
		return LOGIN_SUCCESS;
	}
	public int logout(HttpSession session){//세션에 저장된 로그인정보를 지우는데 받을 값은 필요없다 
		session.removeAttribute("login");
		return LOGOUT_SUCCESS;
	}
	public String findMpassword(String mid, String memail,HttpSession session){
		Member member = memberDao.selectByMid(mid);
		if(member==null) return null;
		if(member.getMemail().equals(memail)==false) return null;
		return member.getMpassword();
	}
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	}
	public Member info(String mpassword,HttpSession session){
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false) {return null;}
		return member;
	}
	public int modify(Member member){
		
	}
	public int withdraw(String mpassword,HttpSession session){
		String mid = (String)session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false){return WITHDRAW_FAIL;}
		memberDao.delete(mid);
		logout(session);
		return WITHDRAW_SUCCESS;
	}
	public boolean isMid(String mid){
		
	}
}
