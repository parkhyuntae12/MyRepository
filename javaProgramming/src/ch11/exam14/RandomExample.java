package ch11.exam14;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r1 = new Random();
		
		Random r2 = new Random(3);
		Random r3 = new Random(3);
		
		System.out.println(r1.nextInt());
		
		System.out.println(r2.nextInt());
		System.out.println(r3.nextInt());
		
		//�ֻ��� ��ȣ
		int num= r1.nextInt(6)+1;
		System.out.println(num);
	}
}