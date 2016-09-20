package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = InputStreamExample.class.getResource("data.txt").getPath();
		
		int count=0;
		//System.out.println(filePath);
		InputStream is = new FileInputStream(filePath);
		while(true){
			int value = is.read();
			if(value==-1) break;
			System.out.println(value);
			count++;
		}
		System.out.println(count);
		System.out.println("읽은 횟수 : "+count);
		is.close();//don't forget
		
		is = new FileInputStream(filePath);
		count=0;
		int value =-1;
		while((value =is.read())!=-1){//isread()를먼저실행한후 value에입력, 그다음 -1과 비교
			System.out.println(value);
			count++;
		}
		System.out.println("읽은 횟수 : "+count);
		is.close();//don't forget
	}
}