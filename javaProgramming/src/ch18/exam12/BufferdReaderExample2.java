package ch18.exam12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferdReaderExample2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader("src/ch18/exam12/NAVER.html");
		BufferedReader br = new BufferedReader(fr);
		
		int count=0;
		while(true){
			String line = br.readLine();//������� �дٰ� ���̻� ������ ������ null
			if(line ==null)break;
			System.out.println((++count)+":"+line);
		}
		
		
	}
}