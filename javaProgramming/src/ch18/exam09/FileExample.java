package ch18.exam09;

import java.io.File;

public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:/Temp/dir1/dir2/dir3");
		if(file.exists()){
			if(file.isDirectory()){
				System.out.println("���丮�� ������");
			}else{
				System.out.println("������ ������");	
			}
		}else{
			System.out.println("�������� ����");
		}
		
		File dir = new File("C:/Temp/dir1/dir2/dir3");
		//dir.mkdir();
		dir.mkdirs();
		
		dir.delete();//dir3�� ����
		
	}
}