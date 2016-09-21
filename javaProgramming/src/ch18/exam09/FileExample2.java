package ch18.exam09;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:/Temp/dir1/dir2/data.txt");
		File parentDir = file.getParentFile();//data.txt의 부모인 dir2까지 폴더생성
		parentDir.mkdirs();
		file.createNewFile();
		
		System.out.println(new Date(file.lastModified()));
		
	}
}