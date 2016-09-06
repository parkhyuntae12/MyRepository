package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,6,4);// bytes 타입배열의 6번째인덱스부터 4개(바이트의갯수)
		System.out.println(str2);*/
		
		//--------------------------------------------------------------
		String str3="홍길동";//한글은 아스키코드로 표현할수없다 
		byte[] strBytes3 = str3.getBytes(); 
		
		String str4 = new String(strBytes3);//한문자당 2바이트 유니코드로 읽겠다
		System.out.println(str4);
		
		String str5 = "홍길동";
		 byte[] strBytes5 = str5.getBytes("UTF-8");//UTF-8=한문자당 3바이트
		                                                       //한문자당 3바이트의 배열을 UTF-8로읽겟다
		 													   //=(인코딩)
		 String str6 = new String(strBytes5,"UTF-8");//utf-8문자셋으로 받은 배열을 다시 utf-8로복원해서
		                                                          //읽겠다.(=디코딩)
		 System.out.println(str6);
		 
		 String str7 = "ab홍길동";
		 byte[] strBytes6 = str7.getBytes("EUC-KR");
		 String str8 = new String(strBytes6,"EUC-KR");
		 System.out.println(str8);
		 String str9 = new String(strBytes6,0,4,"EUC-KR"); //0번째인덱스부터 4번째미만!인덱스까지
		 System.out.println(str9);
}
}