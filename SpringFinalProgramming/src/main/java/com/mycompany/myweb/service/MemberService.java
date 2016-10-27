package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService{
	//실제 실무에서는 class가 아니라 인터페이스로 구현해서 쓴다
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;//세가지 이상의 경우에는 상수를 정해줘야 한다
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;
	
	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL_MID=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_FAIL=0;
	public static final int WITHDRAW_SUCCESS=1;
	
	@Autowired
	private MemberDao memberDao;
	public int join(Member member){//정상실행과 예외만 존재할때 void로 리턴해도 된다
		 memberDao.insert(member);//예외처리 노노
		 return JOIN_SUCCESS;
	}
	public int  login(String mid,String mpassword){
		//session을 이용한 이유는 session에 로그인 정보를 저장하기 위해서
		//서비스에선 session을 사용하지않고 컨트롤러에서 사용하는게 좋다
		Member member = memberDao.selectByMid(mid);
		if(member==null) {return LOGIN_FAIL_MID;}
		if(member.getMpassword().equals(mpassword)==false){return LOGIN_FAIL_MPASSWORD;}
	
		return LOGIN_SUCCESS;
	}
	public int logout(String mid){//세션에 저장된 로그인정보를 지우는데 받을 값은 필요없다, 이 메소드는 없어도된다(의미x)
		return LOGOUT_SUCCESS;
	}
	public String findMpassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);
		if(member==null) return null;//mid 존재여부 검사
		if(member.getMemail().equals(memail)==false) return null;
		return member.getMpassword();
	}
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	}
	public Member info(String mid,String mpassword){
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false) {return null;}
		return member;
	}
	public int modify(Member member){
		//존재하지않는걸 수정할수는없다
		//로그인후 수정가능, 로그인을 인정받앗기때문에 또 검증할 필요없다
		//수정 후 비밀번호를 한번 더묻는다, 비밀번호 확인 후 수정
		Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember.getMpassword().equals(member.getMpassword())==false){return MODIFY_FAIL;};
		int row = memberDao.update(member);
		if(row!=1){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int withdraw(String mid,String mpassword){
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false){return WITHDRAW_FAIL;}
		memberDao.delete(mid);
		logout(mid);
		return WITHDRAW_SUCCESS;
	}
	public boolean isMid(String mid){//아디찾기
		Member member = memberDao.selectByMid(mid);
		if(member==null) return false;
		return true;
	}
	//외부의 다른 API가 들어와서 서비스가 단독으로 실행할수 없는 상황은 되도록이면 제한 
	//ex)session같은경우 WAS를 쓰지않는다(코드가 간단해질수 없지만 종속이 되기때문에 없어선 안되는상황이 발생)
	//dto와 dao만 서비스단에 존재해야 된다
}
