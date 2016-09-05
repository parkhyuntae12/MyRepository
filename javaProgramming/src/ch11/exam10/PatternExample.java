package ch11.exam10;

import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tel ="010-123-1234";
		String tel2 = "013-123-1234";
		String tel3 = "010-1234-1234";
		String tel4 = "010-1234-123";
		
		String regExp = "(010|011)-\\d{3,4}-\\d{4}";//����ǥ����
																	 //{3,4}���ڰ� 3�ڸ��ƴϸ� 4�ڸ�{4}������4�ڸ�
		System.out.println(Pattern.matches(regExp, tel));
		System.out.println(Pattern.matches(regExp, tel2));
		System.out.println(Pattern.matches(regExp, tel3));
		System.out.println(Pattern.matches(regExp, tel4));
	
		String email1 = "hong@naver.com";
		String email2 = "hongnaver.com";
		String email3 = "hong@naver";
		
		String regExp2 = "\\w+@\\w+\\.\\w+";
		
		System.out.println(Pattern.matches(regExp2, email1));
		System.out.println(Pattern.matches(regExp2, email2));
		System.out.println(Pattern.matches(regExp2, email3));
		
	}
}