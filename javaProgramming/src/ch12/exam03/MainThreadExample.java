package ch12.exam03;

public class MainThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� ��ü����
		Calculator calculator = new Calculator();
		
		//������ ��ü ����
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		//���� ��ü�� �� �����忡�� ����
		user1.setCalculator(calculator);
		user2.setCalculator(calculator);
		
		//������ ���� 
		user1.start();
		user2.start();
	}
}