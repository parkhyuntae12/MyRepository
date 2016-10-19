package ch08.service;

import java.util.Date;

import ch08.dao.MemberDao;
import ch08.dto.Member;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setMid("user7");
		member.setMname("사용자7");
		member.setMage(35);
		member.setMbirth(new Date(1996,2,17));		
		
		dao.update(member);
	 }
}