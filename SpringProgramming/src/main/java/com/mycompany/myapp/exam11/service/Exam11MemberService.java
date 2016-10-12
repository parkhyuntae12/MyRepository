package com.mycompany.myapp.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11MemberDao;
import com.mycompany.myapp.exam11.dto.Member;

@Component
public class Exam11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCESS=0;
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;
	
	@Autowired
	public Exam11MemberDao memberDao;
	
	public void join(Member member){
		logger.info("join 처리");
		memberDao.insert(member);//db에 member의 정보를 생성(저장)
	}
	
	public int login(String mid, String mpassword){
		logger.info("login 처리");
		Member member= memberDao.select(mid);//mid를 매개값으로 받으면 select가 db로가서 mid정보를 가져온후 리턴(조회)
		if(member == null){
			return LOGIN_FAIL_MID;
		}else{
			if(member.getMpassword().equals(mpassword)){
				return LOGIN_SUCESS;
			}else{
				return LOGIN_FAIL_MPASSWORD;
			}
		}
	}
}