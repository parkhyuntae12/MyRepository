package ch08.service;

import java.util.Date;

import ch08.dao.MemberDao;
import ch08.dto.Member;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
	
		dao.deleteByMid("user6");//오토커밋 very Dangerous
	 }
}