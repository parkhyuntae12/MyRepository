package ch18.exam05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Writer writer = new FileWriter("src/ch18/exam05/data.txt");
		
		String data = "������ ���� ������ ���ڽ��ϴ�";
		
		/*char[] values = data.toCharArray();
	    writer.write(values);*/
		
		writer.write(data);
		writer.flush();
		
		writer.close();
	}
}