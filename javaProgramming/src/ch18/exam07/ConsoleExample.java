package ch18.exam07;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console console = System.console();
		
		System.out.print("���̵� : ");
		String id = console.readLine();
		
		System.out.print("�н����� : ");
		char[] values = console.readPassword();
		String password = new String(values);
		
		System.out.println("�Էµ� ����");
		System.out.println(id);
		System.out.println(password);
	}
}