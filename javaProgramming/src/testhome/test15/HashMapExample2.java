package testhome.test15;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Student,Integer>map = new HashMap<Student,Integer>();
		
		map.put(new Student(1,"È«±æµ¿"), 95);
		map.put(new Student(1,"È«±æµ¿"), 95);
		
		System.out.println("ÃÑ ¿£Æ®¸® ¼ö : "+map.size());
	}
}