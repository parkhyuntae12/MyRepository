package testhome.test15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student1> set = new HashSet<Student1>();
		set.add(new Student1(1,"ȫ�浿"));
		set.add(new Student1(2,"�ſ��"));
		set.add(new Student1(1,"���ο�"));
		
		Iterator<Student1> iterator = set.iterator();
		while(iterator.hasNext()){
			Student1 student = iterator.next();
			System.out.println(student.studentNum+":"+student.name);
		}
	}
}