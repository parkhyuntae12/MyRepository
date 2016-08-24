package exam11;

import java.util.Scanner;

public class ScoreManagement {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Student[] students = null;
		while(true) {
			System.out.println("------------------------------------------------------------------------");
			if(students == null) {
				System.out.println("1.���л��� | 7.����");
			} else {
				System.out.println("1.���л��� | 2.��� | 3.�Է� | 4.���� | 5.�ְ����� | 6.��� | 7.����");
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.print("����: ");
			String choice = scanner.nextLine();
			if( choice.equals("1") ) {
				System.out.print("���л���: ");
				int totalNum = Integer.parseInt(scanner.nextLine());
				students = new Student[totalNum];
			} else if( choice.equals("2") ) {
				System.out.println("*********************************************");
				System.out.println("�й�\t\t�̸�\t\t����");
				System.out.println("*********************************************");
				for(int i=0; i<students.length; i++) {
					Student student = students[i];//����(����)
					if(student != null) {
						System.out.println(student.no + "\t\t" + student.name + "\t\t" + student.score);
					}
				}
			} else if( choice.equals("3") ) {
				System.out.print("�̸�: ");
				String name = scanner.nextLine();
				System.out.print("����: ");
				int score = Integer.parseInt(scanner.nextLine());
				for(int i=0; i<students.length; i++) {
					if(students[i] == null) {
						Student student = new Student(i, name, score);
						students[i] = student;
						break;
					}
				}
			} else if( choice.equals("4") ) {
				System.out.print("������ �й�: ");
				int sno = Integer.parseInt(scanner.nextLine());
				students[sno] = null;
			} else if( choice.equals("5") ) {
				int max = 0;
				for(Student student : students) {
					if(student != null) {
						int score = student.score;
						if(max < score) {
							max = score;
						}
					}
				}
				
				System.out.println("*********************************************");
				System.out.println("�й�\t\t�̸�\t\t����");
				System.out.println("*********************************************");
				
				for(Student student : students) {
					if(student != null) {
						int score = student.score;
						if(max == score) {
							System.out.println(student.no + "\t\t" + student.name + "\t\t" + student.score);
						}
					}
				}
			} else if( choice.equals("6") ) {
				int count = 0;
				int sum = 0;
				for(Student student : students) {
					if(student != null) {
						count++;
						sum += student.score;
					}
				}
				System.out.println("����: " + (double)sum/count);
			} else if( choice.equals("7") ) {
				break;
			} 
		}
	}
}
