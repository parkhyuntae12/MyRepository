package ch04.exam01;

public class IfExample {
	public static void main(String[] args) {
		System.out.println("���α׷� ����");
		
		int score = 93;

		if(score>90) {
			if(score>=95) {
				System.out.println("A+ ���");
			} else {
				System.out.println("A ���");
			}
		} else if(score>80) {
			System.out.println("B ���");
		} else {
			System.out.println("��Ÿ ���");
		}
		
		System.out.println("���α׷� ����");
	}
}
