package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "¾È³çÇÏ¼¼¿ä";
		//String -> bytes[]
		str.getBytes();
		byte[] bytes1 = str.getBytes();
		System.out.println("byte1.length : "+bytes1.length);
		
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println("byte2.length : "+bytes2.length);
		
		byte[] bytes3 = str.getBytes("UTF-8");
		System.out.println("byte3.length : "+bytes3.length);

		//bytes[] -> String
		String str1 = new String(bytes1);
		System.out.println("str1 : "+str1);
		
		String str2 = new String(bytes2,"EUC-KR");
		System.out.println("str2 : "+str2);
		
		String str3 = new String(bytes3,"UTF-8");
		System.out.println("str2 : "+str3);
	}
}