package testhome.test15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student1> set = new HashSet<Student1>();
		set.add(new Student1(1,"È«±æµ¿"));
		set.add(new Student1(2,"½Å¿ë±Ç"));
		set.add(new Student1(1,"Á¶¹Î¿ì"));
		
		Iterator<Student1> iterator = set.iterator();
		while(iterator.hasNext()){
			Student1 student = iterator.next();
			System.out.println(student.studentNum+":"+student.name);
		}
	}
}