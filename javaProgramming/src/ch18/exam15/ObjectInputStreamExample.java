package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputStreamExample{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Member member2 = (Member) ois.readObject(); // member와 member2가 참조하는 객체는다르다
		
		fis.close();
		ois.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMpassword()); //transient
		System.out.println(member2.getMage());
		System.out.println(Member.getNation());//복원이아니라 원래 박혀잇는 데이터를 불러온것
		
	}
}