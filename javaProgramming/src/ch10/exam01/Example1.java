package ch10.exam01;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true){
		try{
			System.out.println("�Է� : ");
			String data = scanner.nextLine();
			int value = Integer.parseInt(data);
			System.out.println(value);
		}catch(Exception e){
			System.out.println("���ڰ� �ƴѵ�");
		}finally{
			System.out.println("�����ǽ��� ");
		}
		}
	}
}
