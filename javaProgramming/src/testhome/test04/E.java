package testhome.test04;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run){
			System.out.println("------------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ�| 4. ����");
			System.out.println("------------------------------------");
			System.out.println("����> ");
			
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("���ݾ� : ");
				balance+=scanner.nextInt();
				break;
			case 2:
				System.out.println("��ݾ� : ");
				balance-=scanner.nextInt();
				break;
			case 3:
				System.out.println("�ܾ� : ");
				System.out.println(balance);
				break;
			case 4:
				run=false;
				break;
			}
		}	
		System.out.println("����");
	}
}