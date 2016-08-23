package ch05.exam03;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�л���: ");
		String strNum = scanner.nextLine();
		int num = Integer.parseInt(strNum);
		int[] scores = new int[num];
		
		for(int i=0; i<scores.length; i++) {
			System.out.print("����: ");
			String data = scanner.nextLine();
			int score =  Integer.parseInt(data);
			scores[i] = score;
		}
		
		int sum = 0;
		for(int s : scores) {
			sum += s;
		}
		System.out.println("����: " + sum);
		System.out.println("���: " + (double) sum / scores.length);
	}
}
