package ch18.exam07;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�ֿܼ� ����մϴ�."); //out�� printstream�� �ڽ�,printstream�� outputstream�� ���
		
		OutputStream os = System.out;//println�� printstream�� �޼ҵ�
		String data = "�ֿܼ� ����մϴ�.";
		byte[] values = data.getBytes();
		os.write(values);
		os.flush();
		os.close();
		
		System.err.println("�ֿܼ� ����մϴ�.");
	}
}