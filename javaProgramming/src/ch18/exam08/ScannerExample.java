package ch18.exam08;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner1 = new Scanner(System.in);//()안에는 InputStream의 자식객체는 모두 올수 있다
		
		System.out.print("이름 : ");
		String name = scanner1.nextLine();//입력이되지않을때는 대기상태,입력이되고 엔터를 치면 변환후 리턴
	
		System.out.print("나이 : ");
		int age = scanner1.nextInt();//nextInt는 엔터키 전의 data만  읽는다(엔터키는 남아있다), nextLine은 엔터키까지 물고 온다
		
		System.out.print("키 : ");
		double height = scanner1.nextDouble();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}