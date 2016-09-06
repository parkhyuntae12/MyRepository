package ch11.exam10;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[100];
		
		System.out.print("입력 : ");
		int readByteNo = System.in.read(bytes);
		
		//String str = new String(bytes);
		String str = new String(bytes,0,readByteNo-2);//readByteNo-2 2를빼준이유는 엔터키부분을빼려고
																    // hello/r/n /r/n(엔터키)
		System.out.println(str);
	}
}