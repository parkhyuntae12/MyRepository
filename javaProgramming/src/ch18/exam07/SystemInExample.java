package ch18.exam07;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SystemInExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//�Ѱ��� Ű�� �б�
		InputStream is =System.in;											
		
		/*System.out.print("Ű �ϳ��� �Է� : ");
		
		 int keyCode =is.read();// == int keyCode = System.in.read();
		System.out.println(keyCode+":"+(char)keyCode);*/
	
		//�ѱ۰� ���� ����Ű�� ������ �б�
		System.out.print("����Ű�� �Է� : ");
		byte[] values = new byte[100];
		int byteNum= is.read(values);
		System.out.println(Arrays.toString(values));
		String data = new String(values,0,byteNum-2);
		System.out.println(data);
	}
}