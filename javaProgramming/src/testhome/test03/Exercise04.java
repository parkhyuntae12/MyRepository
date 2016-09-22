package testhome.test03;

public class Exercise04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pencils= 534;
		int student= 30;
		
		//학생 한명이 가지는 연필수
		int pencilsPerStudent = pencils/student;
		System.out.println(pencilsPerStudent);
		
		//남은 연필수
		int pencilsLeft=pencils%student;
		System.out.println(pencilsLeft);
	}
}