package ch18.exam08;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner1 = new Scanner(System.in);//()�ȿ��� InputStream�� �ڽİ�ü�� ��� �ü� �ִ�
		
		System.out.print("�̸� : ");
		String name = scanner1.nextLine();//�Է��̵����������� ������,�Է��̵ǰ� ���͸� ġ�� ��ȯ�� ����
	
		System.out.print("���� : ");
		int age = scanner1.nextInt();//nextInt�� ����Ű ���� data��  �д´�(����Ű�� �����ִ�), nextLine�� ����Ű���� ���� �´�
		
		System.out.print("Ű : ");
		double height = scanner1.nextDouble();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}